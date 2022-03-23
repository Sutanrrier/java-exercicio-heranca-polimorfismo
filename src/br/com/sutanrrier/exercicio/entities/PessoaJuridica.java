package br.com.sutanrrier.exercicio.entities;

public class PessoaJuridica extends Pessoa {
	private Integer num_funcionarios;

	public PessoaJuridica(String nome, Double renda_anual, Integer num_funcionarios) {
		super(nome, renda_anual);
		this.num_funcionarios = num_funcionarios;
	}

	public Integer getNum_funcionarios() {
		return num_funcionarios;
	}

	public void setNum_funcionarios(Integer num_funcionarios) {
		this.num_funcionarios = num_funcionarios;
	}

	@Override
	public double impostoPago() {
		return (num_funcionarios > 10) ? renda_anual * 0.14 : renda_anual * 0.16;
	}
	
}
