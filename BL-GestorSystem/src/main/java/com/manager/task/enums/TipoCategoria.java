package com.manager.task.enums;

public enum TipoCategoria {
	
	PRODUTO("Produtos"),
	ESTOQUE("Estoque"),
	USUARIO("Usuários"),
	FINANCEIRO("Financeiro"),
	SERVICOS("Serviços"),
	CONFIGURACAO("Configurações");

	private String descricao;

	private TipoCategoria(String descricao) {
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
