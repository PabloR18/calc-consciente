package aplication;

import java.util.Scanner;

import util.CalculadoraConsciente;

public class Start_CalculadoraCosnciente {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		CalculadoraConsciente teste = new CalculadoraConsciente(0, 0);
		
		System.out.print("Informe seu nome: "); 
		String nome = entrada.next();
		System.out.print("Informe seu salario: R$");
		double salarioLiquido = entrada.nextDouble();
		teste.dadosSalario(salarioLiquido);
		teste.dadosSalario();
		
		System.out.println(teste.toString());
		
		System.out.print("Cadastre o valor do Objeto: R$");
		double valorObjeto = entrada.nextDouble();
		teste.setValorObjeto(valorObjeto);
		teste.cadastrarObjeto();
		
		entrada.close();
	}

}
