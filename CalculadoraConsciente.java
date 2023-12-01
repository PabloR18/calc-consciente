package util;

public class CalculadoraConsciente {
	private double ganhoDia;
	private double ganhoHora;
	private double valorObjeto;
	
	public CalculadoraConsciente(double ganhoDia, double ganhoHora) {
		this.ganhoDia = ganhoDia;
		this.ganhoHora = ganhoHora;
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
	
	// ---------------------------------------------------------------------
	
	public void dadosSalario(double salario) {
		double salarioPorDia = Math.round(salario / 22);
		setGanhoDia(salarioPorDia);
	}
	
	public void dadosSalario() {
		double salarioPorHora = Math.round(getGanhoDia() / 8);
		setGanhoHora(salarioPorHora);
	}
	
	public void cadastrarObjeto() {
		
		int diasTrabalhados = 0;
		while (getValorObjeto() >= getGanhoDia()) {
			diasTrabalhados++;
		}
		
		double horasTrabalhadas = 0.0;
		while (getValorObjeto() > getGanhoHora()) {
			horasTrabalhadas++;
		}
		
		System.out.println("Para comprar um Objeto de R$" + getValorObjeto() + " Você precisará trabalhar: ");
		System.out.println("Dias: " + diasTrabalhados);
		System.out.println("Horas: " + horasTrabalhadas);
		
	}
	
	public String toString() {
		return "-- Dados do Trabalhador --" + "\n-- Salario/Dia: R$" + getGanhoDia() + "  --\n-- Salario/Hora: R$" + getGanhoHora() + "  --\n--------------------------";
	}
	
	
}
