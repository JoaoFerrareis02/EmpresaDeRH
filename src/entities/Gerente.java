package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Funcionario {

	private String senha;
	private ArrayList<Funcionario> equipe;
	
	public Gerente() {
		super();
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe a senha: ");
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
	
	public boolean validarAcesso() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe a senha para validação: ");
		String s = sc.nextLine();
		return this.senha.equals(s);
	} 
	
	public void alterarSenha() {
		Scanner sc = new Scanner(System.in);
		if(this.validarAcesso()) {
			System.out.print("Informe a nova senha: ");
			String s = sc.nextLine();
			this.setSenha(s);
		}else {
			System.out.println("A senha informada está incorreta.");
		}
	}
	
	public double custoEquipe() {
		double sum = 0.0;
		for (Funcionario funcionario : equipe) {
			sum += funcionario.getSalario();
		}
		sum += this.salario;
		return sum;
	}
	
	public void listarEquipe() {
		System.out.println("Gerente : "+ this.nome);
		System.out.println("Equipe:");
		for (Funcionario funcionario : equipe) {
			System.out.println(funcionario.getNome());
		}
	}
	
	public void inserirFuncEquipe(Funcionario f) {
		this.equipe.add(f);
	}
	
	public void listarDados() {
		System.out.println("*** GERENTE ***");
		super.listarDados();
	}
	
}
