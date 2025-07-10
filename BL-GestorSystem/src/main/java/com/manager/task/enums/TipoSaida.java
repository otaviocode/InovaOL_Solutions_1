package com.manager.task.enums;

public enum TipoSaida {
	
	VENDA("Venda"),
	CONSUMO_INTERNO("Consumo Interno"),
	DEVOLUCAO("Devolução"),
	AVARIADO("Produto Avariado");

	private String descricao;

	private TipoSaida(String descricao) {
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
