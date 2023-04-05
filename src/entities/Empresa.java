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

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(ArrayList<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public void folhaPagamento() {
		System.out.println("*** FOLHA DE PAGAMENTO ***");
		System.out.println("*** FUNCIONARIOS ***");
		for (Funcionario funcionario : funcionarios) {
			System.out.printf("Nome: %s - Salario: R$ %.2f%n", funcionario.getNome(), funcionario.getSalario());
		}
		System.out.println("*** GERENTES ***");
		for (Gerente gerente : gerentes) {
			System.out.printf("Nome: %s - Salario: R$ %.2f - S.Equipe: R$ %.2f%n", gerente.getNome(),
					gerente.getSalario(), gerente.custoEquipe());
		}
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
			if (f.getDtContr().compara(funcionario.getDtContr()) == 1) {
				f = funcionario;
			}
		}
		return f;
	}

	public Funcionario funcionarioMaisVelho() {
		Funcionario f = funcionarios.get(0);
		for (Funcionario funcionario : funcionarios) {
			if (f.getDtNasc().compara(funcionario.getDtNasc()) == 1) {
				f = funcionario;
			}
		}
		return f;
	}

	private Funcionario localizarFuncionario(String cpf) {
		return funcionarios.stream().filter(x -> x.getCpf().equals(cpf)).findFirst().orElse(null);
	}
	
	private Gerente localizarGerente(String cpf) {
		return gerentes.stream().filter(x -> x.getCpf().equals(cpf)).findFirst().orElse(null);
	}
	
	public void atribuirFuncGer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o cpf do funcionário: ");
		Funcionario f = localizarFuncionario(sc.nextLine());
		System.out.print("Informe o cpf do gerente: ");
		Gerente g = localizarGerente(sc.nextLine());
		g.inserirFuncEquipe(f);
	}

}
