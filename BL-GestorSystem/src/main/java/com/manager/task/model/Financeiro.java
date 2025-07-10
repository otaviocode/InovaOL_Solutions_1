package com.manager.task.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.manager.task.enums.TipoFinanceiro;
import com.manager.task.enums.TipoPagamento;

@Entity
@Table(name = "financeiro")
@SequenceGenerator(name = "seq_financeiro", sequenceName = "seq_financeiro", initialValue = 1, allocationSize = 1)
public class Financeiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_financeiro")
	private Long id;

	/* put here the enum tipoFinanceiro */
	@Enumerated(EnumType.STRING)
	private TipoFinanceiro tipoFinanceiro;

	private String descricao;
	private String categoria;
	private Double valor;
	private Date data;

	/* put here the enum tipoPagamento */
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;

	private String observacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Financeiro other = (Financeiro) obj;
		return Objects.equals(id, other.id);
	}

}
