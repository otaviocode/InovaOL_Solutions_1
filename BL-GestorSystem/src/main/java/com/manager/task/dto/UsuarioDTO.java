package com.manager.task.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String fotoPerfilBase64;

	private String nomeCompleto;
	private String email;
	private String loginUsuario;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String senha;

	private String telefone;
	private Date dataNascimento;
	private String cep;
	private String endereco;
	private Integer numeroResidencia;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFotoPerfilBase64() {
		return fotoPerfilBase64;
	}

	public void setFotoPerfilBase64(String fotoPerfilBase64) {
		this.fotoPerfilBase64 = fotoPerfilBase64;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(Integer numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
