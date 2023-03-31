package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {

	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Gerente> gerentes;

	public Empresa() {
		this.funcionarios = new ArrayList<>();
		this.gerentes = new ArrayList<>();
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public ArrayList<Gerente> getGerentes() {
		return gerentes;
	}

	public void folhaPagamento() {
		double sum = 0.0;
		System.out.println("*** FOLHA DE PAGAMENTO MENSAL ***");
		for (Funcionario funcionario : funcionarios) {
			System.out.printf("Nome: %s (Salário: R$%.2f)%n", funcionario.nome, funcionario.salario);
			sum += funcionario.getSalario();
		}
		for (Gerente gerente : gerentes) {
			System.out.printf("Nome: %s (Salário: R$%.2f) - (Custo total da equipe: R$ %.2f)%n", gerente.nome,
					gerente.salario, gerente.custoEquipe());
			sum += gerente.getSalario();
		}
		System.out.printf("Custo mensal da empresa: R$ %.2f%n", sum);
	}

	public void contratarFuncionario() {
		this.funcionarios.add(new Funcionario());
	}

	public void contratarGerente() {
		this.gerentes.add(new Gerente());
	}

	public Funcionario funcionarioMaisAntigo() {
		Funcionario f = funcionarios.get(0);
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getDtContr().compara(f.getDtContr()) == -1)
				f = funcionario;
		}
		return f;
	}

	public Funcionario funcionarioMaisVelho() {
		Funcionario f = funcionarios.get(0);
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getDtNasc().compara(f.getDtNasc()) == -1)
				f = funcionario;
		}
		return f;
	}

	private Funcionario localizarFuncionario(String cpf) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(cpf))
				return funcionario;
		}
		return null;
	}

	private Gerente localizarGerente(String cpf) {
		for (Gerente gerente : gerentes) {
			if (gerente.getCpf().equals(cpf))
				return gerente;
		}
		return null;
	}

	public void atribuirFuncGer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o CPF do funcionário: ");
		String cpfFunc = sc.nextLine();
		System.out.print("Informe o CPF do gerente: ");
		String cpfGer = sc.nextLine();
		Funcionario f = this.localizarFuncionario(cpfFunc);
		Gerente g = this.localizarGerente(cpfGer);
		if (g != null && f != null) {
			g.inserirFuncEquipe(f);
			System.out.println("Funcionário adicionado a equipe!");
		} else {
			System.out.println("Funcionário não adicionado a equipe!");
		}
	}
}
