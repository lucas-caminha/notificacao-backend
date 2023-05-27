package br.com.bahia.backend.notificacao.dto;

public class InsertNotificacaoDTO {

	private String deMensagem;
	private Integer cdUsuario;
	
	public InsertNotificacaoDTO() {}

	public String getDeMensagem() {
		return deMensagem;
	}

	public void setDeMensagem(String deMensagem) {
		this.deMensagem = deMensagem;
	}

	public Integer getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	
}
