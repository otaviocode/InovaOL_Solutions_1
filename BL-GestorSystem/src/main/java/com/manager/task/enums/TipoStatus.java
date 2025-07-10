package com.manager.task.enums;

public enum TipoStatus {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	private TipoStatus(String descricao) {
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
