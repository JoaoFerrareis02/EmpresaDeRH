package entities;

import java.util.Scanner;

public class Data {

	private int dia;
	private int mes;
	private int ano;

	public Data() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o dia: ");
		this.dia = sc.nextInt();
		System.out.print("Informe o mes: ");
		this.mes = sc.nextInt();
		System.out.print("Informe o ano: ");
		this.ano = sc.nextInt();
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int compara(Data d) {
		if (this.ano > d.getAno()) {
			return 1;
		} else if (this.ano < d.getAno()) {
			return -1;
		} else if (this.mes > d.getMes()) {
			return 1;
		} else if (this.mes < d.getMes()) {
			return -1;
		} else if (this.dia > d.getDia()) {
			return 1;
		} else if (this.dia < d.getDia()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return  dia + "/" + mes + "/" + ano;
	}
	
	

}
