package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Empresa;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Empresa empresa = new Empresa();
		escolhas(empresa);
	}
		

	public static void escolhas(Empresa empresa) {
		Scanner sc = new Scanner(System.in);
		int x = 1;
		while (x != 0) {
			System.out.println("Bem vindo ao RH da empresa!");
			System.out.println("Digite o número do que vc quer :");
			System.out.println("1 - Mostrar a folha de pagamento mensal");
			System.out.println("2 - Contratar funcionário");
			System.out.println("3 - Contratar gerente");
			System.out.println("4 - Atribuir funcionário ao gerente");
			System.out.println("5 - Funcionário mais antigo da empresa");
			System.out.println("6 - Funcionário mais velho");
			System.out.println("0 - Sair");
			x = sc.nextInt();
			switch (x) {
			case 1:
				empresa.folhaPagamento();
				break;
			case 2:
				empresa.contratarFuncionario();
				break;
			case 3:
				empresa.contratarGerente();
				break;
			case 4:
				empresa.atribuirFuncGer();
				break;
			case 5:
				empresa.funcionarioMaisAntigo().listarDados();
				break;
			case 6:
				empresa.funcionarioMaisVelho().listarDados();
				break;
			default:
				break;
			}
		}

	}

}
