package com.manager.task.enums;

public enum TipoRelatorio {
	
	SAIDAS("Saidas"),
	ENTRADAS("Entradas"),
	PRODUTOS_CRITICOS("Produtos Críticos"),
	ESTOQUE_ATUAL("Estoque Atual");

	private String descricao;

	private TipoRelatorio(String descricao) {
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
