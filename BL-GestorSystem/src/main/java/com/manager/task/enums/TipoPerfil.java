package com.manager.task.enums;

public enum TipoPerfil {

	ADMINISTRADOR("Administrador"), USUARIO_COMUM("Usuário Comum");

	private String descricao;

	private TipoPerfil(String descricao) {
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
