package entities;

import java.util.Scanner;

public class Funcionario {

	protected String nome;
	protected String cpf;
	protected double salario;
	protected Data dtNasc;
	protected Data dtContr;

	public Funcionario() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o nome: ");
		this.nome = sc.nextLine();
		System.out.print("Informe o cpf: ");
		this.cpf = sc.nextLine();
		System.out.print("Informe o salario:  ");
		this.salario = sc.nextDouble();
		System.out.println("Informe a data de nascimento:");
		this.dtNasc = new Data();
		System.out.println("Informe a data de contratacao:");
		this.dtContr = new Data();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Data getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Data dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Data getDtContr() {
		return dtContr;
	}

	public void setDtContr(Data dtContr) {
		this.dtContr = dtContr;
	}

	public void listarDados() {
		System.out.println("*** DADOS DO FUNCIONARIO ***");
		System.out.printf("Nome: %s (CPF: %s)%n", this.nome, this.cpf);
		System.out.printf("Salario: R$ %.2f%n", this.salario);
		System.out.printf("Data de nascimento: %s%n", this.dtNasc);
		System.out.printf("Data de contratacao: %s%n", this.dtContr);
	}

}
