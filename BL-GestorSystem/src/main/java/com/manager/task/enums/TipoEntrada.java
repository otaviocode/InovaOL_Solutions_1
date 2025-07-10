package com.manager.task.enums;

public enum TipoEntrada {
	
	COMPRA("Compra"),
	DEVOLUCAO("Devoluçaõ ao cliente"),
	AJUSTE("Ajuste Manual");

	private String descricao;

	private TipoEntrada(String descricao) {
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
