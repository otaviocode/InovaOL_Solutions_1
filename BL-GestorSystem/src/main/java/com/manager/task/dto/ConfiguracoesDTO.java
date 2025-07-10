package com.manager.task.dto;

import java.io.Serializable;

public class ConfiguracoesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeEmpresa;
	/* put here a enum tipoIdiomaPadrao */
	/* put here a enum tipoFusoHorario */
	private Boolean sistemaManutencao;

	private Integer tamanhoMinSenha;
	private Boolean caracEspecial;
	private Boolean numSenha;
	private Boolean letrasMaiusculas;
	private Integer tempoSessao;
	private Boolean autDoisFatores;
	private String servidorSMTP;
	private Integer portaSMTP;
	private String usuarioSMTP;
	private String senhaSMTP;
	private Boolean useSSLeTLS;
	/* put here a enum tipoTemaSistema */
	private Boolean dicasSistema;
	private Boolean animacoes;
	/* put here a enum frequenciaBackup */
	/* put here a enum nivelLogSistema */
	private Boolean rotacaoAutomatica;
	private String caminhoBackup;

	/* this must be fully encrypted! */
	private String chaveAPI;

	/* this must be fully encrypted! */
	private String urlWebHook;
	private Boolean integracoesTerceiros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Boolean getSistemaManutencao() {
		return sistemaManutencao;
	}

	public void setSistemaManutencao(Boolean sistemaManutencao) {
		this.sistemaManutencao = sistemaManutencao;
	}

	public Integer getTamanhoMinSenha() {
		return tamanhoMinSenha;
	}

	public void setTamanhoMinSenha(Integer tamanhoMinSenha) {
		this.tamanhoMinSenha = tamanhoMinSenha;
	}

	public Boolean getCaracEspecial() {
		return caracEspecial;
	}

	public void setCaracEspecial(Boolean caracEspecial) {
		this.caracEspecial = caracEspecial;
	}

	public Boolean getNumSenha() {
		return numSenha;
	}

	public void setNumSenha(Boolean numSenha) {
		this.numSenha = numSenha;
	}

	public Boolean getLetrasMaiusculas() {
		return letrasMaiusculas;
	}

	public void setLetrasMaiusculas(Boolean letrasMaiusculas) {
		this.letrasMaiusculas = letrasMaiusculas;
	}

	public Integer getTempoSessao() {
		return tempoSessao;
	}

	public void setTempoSessao(Integer tempoSessao) {
		this.tempoSessao = tempoSessao;
	}

	public Boolean getAutDoisFatores() {
		return autDoisFatores;
	}

	public void setAutDoisFatores(Boolean autDoisFatores) {
		this.autDoisFatores = autDoisFatores;
	}

	public String getServidorSMTP() {
		return servidorSMTP;
	}

	public void setServidorSMTP(String servidorSMTP) {
		this.servidorSMTP = servidorSMTP;
	}

	public Integer getPortaSMTP() {
		return portaSMTP;
	}

	public void setPortaSMTP(Integer portaSMTP) {
		this.portaSMTP = portaSMTP;
	}

	public String getUsuarioSMTP() {
		return usuarioSMTP;
	}

	public void setUsuarioSMTP(String usuarioSMTP) {
		this.usuarioSMTP = usuarioSMTP;
	}

	public String getSenhaSMTP() {
		return senhaSMTP;
	}

	public void setSenhaSMTP(String senhaSMTP) {
		this.senhaSMTP = senhaSMTP;
	}

	public Boolean getUseSSLeTLS() {
		return useSSLeTLS;
	}

	public void setUseSSLeTLS(Boolean useSSLeTLS) {
		this.useSSLeTLS = useSSLeTLS;
	}

	public Boolean getDicasSistema() {
		return dicasSistema;
	}

	public void setDicasSistema(Boolean dicasSistema) {
		this.dicasSistema = dicasSistema;
	}

	public Boolean getAnimacoes() {
		return animacoes;
	}

	public void setAnimacoes(Boolean animacoes) {
		this.animacoes = animacoes;
	}

	public Boolean getRotacaoAutomatica() {
		return rotacaoAutomatica;
	}

	public void setRotacaoAutomatica(Boolean rotacaoAutomatica) {
		this.rotacaoAutomatica = rotacaoAutomatica;
	}

	public String getCaminhoBackup() {
		return caminhoBackup;
	}

	public void setCaminhoBackup(String caminhoBackup) {
		this.caminhoBackup = caminhoBackup;
	}

	public String getChaveAPI() {
		return chaveAPI;
	}

	public void setChaveAPI(String chaveAPI) {
		this.chaveAPI = chaveAPI;
	}

	public String getUrlWebHook() {
		return urlWebHook;
	}

	public void setUrlWebHook(String urlWebHook) {
		this.urlWebHook = urlWebHook;
	}

	public Boolean getIntegracoesTerceiros() {
		return integracoesTerceiros;
	}

	public void setIntegracoesTerceiros(Boolean integracoesTerceiros) {
		this.integracoesTerceiros = integracoesTerceiros;
	}

}
