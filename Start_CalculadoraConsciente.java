package aplication;

import java.util.Scanner;

import util.CalculadoraConsciente;

public class Start_CalculadoraCosnciente {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		CalculadoraConsciente teste = new CalculadoraConsciente(0, 0);
	
		teste.perguntas(entrada);
	
		entrada.close();
	}

}
