package util;

import java.util.Scanner;

public class CalculadoraConsciente {

	private String nome;
	private double salarioLiquido;
	private double ganhoDia;
	private double ganhoHora;
	private double valorObjeto;
	private int quantidadeParcelas;

	public CalculadoraConsciente(double ganhoDia, double ganhoHora) {
		this.ganhoDia = ganhoDia;
		this.ganhoHora = ganhoHora;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public double getGanhoDia() {
		return ganhoDia;
	}

	public void setGanhoDia(double ganhoDia) {
		this.ganhoDia = ganhoDia;
	}

	public double getGanhoHora() {
		return ganhoHora;
	}

	public void setGanhoHora(double ganhoHora) {
		this.ganhoHora = ganhoHora;
	}

	public double getValorObjeto() {
		return valorObjeto;
	}

	public void setValorObjeto(double valorObjeto) {
		this.valorObjeto = valorObjeto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	
	// ---------------------------------------------------------------------

	public void dadosSalario(double salario) {
		double salarioPorHora = Math.round(salario / 220);
		setGanhoHora(salarioPorHora);
	}
	
	public void dadosSalario() {
		double salarioPorDia = Math.round(getGanhoHora() * 8);
		setGanhoDia(salarioPorDia);
	}

	
	public void perguntas(Scanner entrada) {
		
		System.out.print("Informe seu nome: "); 
		String nome = entrada.next();
		setNome(nome);
		
		System.out.print("Por gentileza, Sr(a)" + getNome() + ", Informe seu rendimento mensal: ");
		double salarioLiquido = entrada.nextDouble();
		setSalarioLiquido(salarioLiquido);
		dadosSalario(getSalarioLiquido());
		dadosSalario();
		
		System.out.print("Tudo bem, agora me informe o nome do Produto que deseja comprar: ");
		String nomeProduto = entrada.next();
		
		System.out.print("Ok, agora, informe o valor do Produto: ");
		double valorProduto = entrada.nextDouble();
		setValorObjeto(valorProduto);
		
		System.out.print("Muito bem, agora me informe a quantidade que planeja comprar: ");
		int quantidadeProduto = entrada.nextInt();
		
		System.out.print("Certo, mais uma coisa, Como será pago o Produto ? Informe (1) para pagamento avista ou (2) para Cartão de Crédito: ");
		int formaPagamento = entrada.nextInt();
		
		switch (formaPagamento) {
		case 1:
			relatorio(formaPagamento);
			break;

		case 2:
			System.out.print("Certo, me informa a quantidade de Parcelas: ");
			int quantidadeParcelas = entrada.nextInt();
			setQuantidadeParcelas(quantidadeParcelas);
			relatorio(formaPagamento);
			break;
			
		default:
			System.out.println("Opção Invalida!!");
			break;
		}
	}
	
	public int diasTrabalhados() {
		
		int diasTrabalhados = 0;
		final double valorDia = getGanhoDia();
		double valorDiaFinal = 0;
		
		while (getValorObjeto() > getGanhoDia() && getValorObjeto() >= valorDiaFinal) {
			valorDiaFinal += valorDia;
			diasTrabalhados++;
		}
		
		return diasTrabalhados;
	}

	public double horasTrabalhadas() {

		double horasTrabalhadas = 0.0;
		final double valorHora = getGanhoHora();
		double valorHoraFinal = 0.0;
		
		while (getValorObjeto() > getGanhoHora() && getValorObjeto() >= valorHoraFinal) {
			valorHoraFinal += valorHora;
			horasTrabalhadas++;
		}

		return horasTrabalhadas;

	}

	public void relatorio(int formaPagamento) {
		
		switch (formaPagamento) {
		case 1: 
			System.out.println();
			System.out.println("-------------------- RELATORIO --------------------");
			System.out.println("Sr(a)" + getNome() + ", Com base nos dados informados o senhor:");
			System.out.println("Precisará trabalhar " + diasTrabalhados() + " Dias ou " + horasTrabalhadas() + " Horas Para pagar o Produto.");
			System.out.println("Como sua forma de pagamento escolhida foi Avista, seu rendimento no proximo mês está limitado a R$" + (getSalarioLiquido() - getValorObjeto()));
			System.out.println("Pense bem antes de comprar.");
			break;
		case 2:
			System.out.println();
			System.out.println("-------------------- RELATORIO --------------------");
			System.out.println("Sr(a)" + getNome() + ", Com base nos dados informados o senhor:");
			System.out.println("Precisará trabalhar " + diasTrabalhados() + " Dias ou " + horasTrabalhadas() + " Horas Para pagar o Produto.");
			System.out.println("Como sua forma de pagamento escolhida foi Cartão de Crédito em " + getQuantidadeParcelas() + " parcelas de R$" + (getValorObjeto() / getQuantidadeParcelas()) + ", seu rendimento nos proximos " + getQuantidadeParcelas() + " meses está limitado a R$" + (getSalarioLiquido() - (getValorObjeto() / getQuantidadeParcelas())));
			System.out.println("Pense bem antes de comprar.");
			break;
		}
	}
	
}
