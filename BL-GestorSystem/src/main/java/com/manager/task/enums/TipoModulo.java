package com.manager.task.enums;

public enum TipoModulo {
	
	PRODUTO("Produtos"),
	ESTOQUE("Estoque"),
	USUARIO("Usuários"),
	FINANCEIRO("Financeiro"),
	SERVICOS("Serviços"),
	CONFIGURACAO("Configurações"),
	OUTROS("Outros");

	private String descricao;

	private TipoModulo(String descricao) {
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
