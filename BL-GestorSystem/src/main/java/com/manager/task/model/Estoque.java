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

import com.manager.task.enums.TipoEntrada;
import com.manager.task.enums.TipoRelatorio;
import com.manager.task.enums.TipoSaida;

@Entity
@Table(name = "estoque")
@SequenceGenerator(name = "seq_estoque", sequenceName = "seq_estoque", initialValue = 1, allocationSize = 1)
public class Estoque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estoque")
	private Long id;

	private Date dataInicial;
	private Date dataFinal;
	private Integer codProduto;
	private String responsavel;
	private Integer qtd;

	/*
	 * We need to insert the enum "TipoSaida!" and "tipoEntrada!" and
	 * "tipoRelatorio" later!
	 */

	@Enumerated(EnumType.STRING)
	private TipoSaida tipoSaida;

	@Enumerated(EnumType.STRING)
	private TipoEntrada tipoEntrada;

	@Enumerated(EnumType.STRING)
	private TipoRelatorio tipoRelatorio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
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
		Estoque other = (Estoque) obj;
		return Objects.equals(id, other.id);
	}

}
