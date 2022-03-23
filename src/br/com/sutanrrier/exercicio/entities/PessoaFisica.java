package br.com.sutanrrier.exercicio.entities;

public class PessoaFisica extends Pessoa{
	
	private Double gastos_saude;

	public PessoaFisica(String nome, Double renda_anual, Double gastos_saude) {
		super(nome, renda_anual);
		this.gastos_saude = gastos_saude;
	}

	public double getGastos_saude() {
		return gastos_saude;
	}

	public void setGastos_saude(Double gastos_saude) {
		this.gastos_saude = gastos_saude;
	}

	@Override
	public double impostoPago() {
		double total = 0;
		
		if(renda_anual < 20000) {
			total += renda_anual * 0.15;
		}
		else {
			total += renda_anual * 0.25;
		}
		
		if(gastos_saude > 0) {
			total -= gastos_saude * 0.5;
		}
		return total;
	}
	
	
}
