package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Funcionario {

	private String senha;
	private ArrayList<Funcionario> equipe;

	public Gerente() {
		super();
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a senha: ");
		this.senha = sc.nextLine();
		this.equipe = new ArrayList<>();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Funcionario> getEquipe() {
		return equipe;
	}

	public void setEquipe(ArrayList<Funcionario> equipe) {
		this.equipe = equipe;
	}

	public boolean validarAcesso() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a senha atual: ");
		String s = sc.nextLine();
		return s.equals(this.senha);
	}

	public void alterarSenha() {
		if (this.validarAcesso()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Informe a senha nova: ");
			String s = sc.nextLine();
			this.setSenha(s);
		}
	}

	public double custoEquipe() {
		double sum = this.salario;
		for (Funcionario funcionario : equipe) {
			sum += funcionario.getSalario();
		}
		return sum;
	}

	public void listarEquipe() {
		System.out.println(this.nome);
		for (Funcionario funcionario : equipe) {
			System.out.println(funcionario.getNome());
		}
	}

	public void inserirFuncEquipe(Funcionario f) {
		this.equipe.add(f);
	}

	@Override
	public void listarDados() {
		super.listarDados();
		System.out.println("Funcao: Gerente");
	}

}
