package com.manager.task.enums;

public enum TipoPagamento {

	DINHEIRO("Dinheiro"), CARTAO("Cartão"), PIX("Pix"), BOLETO("Boleto");

	private String descricao;

	private TipoPagamento(String descricao) {
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
