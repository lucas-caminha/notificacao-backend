package br.com.bahia.backend.notificacao.dto;

public class UpdateNotificacaoDTO {
	
	private Integer cdNotificacao;
	private String deMensagem;
	
	public UpdateNotificacaoDTO() {}
	
	public Integer getCdNotificacao() {
		return cdNotificacao;
	}
	public void setCdNotificacao(Integer cdNotificacao) {
		this.cdNotificacao = cdNotificacao;
	}
	public String getDeMensagem() {
		return deMensagem;
	}
	public void setDeMensagem(String deMensagem) {
		this.deMensagem = deMensagem;
	}
	
}
