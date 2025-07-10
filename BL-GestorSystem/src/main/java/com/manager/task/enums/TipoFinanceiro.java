package com.manager.task.enums;

public enum TipoFinanceiro {

	RECEITA("Receita"), DESPESA("Despesa");

	private String descricao;

	private TipoFinanceiro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}
