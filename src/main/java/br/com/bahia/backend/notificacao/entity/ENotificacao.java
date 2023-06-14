package br.com.bahia.backend.notificacao.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "enotificacao")
public class ENotificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdnotificacao")
	private Integer cdNotificacao;
	@Column(name = "demensagem")
	private String deMensagem;
	@Column(name = "dtcriacao")
	private LocalDate dtCriacao;
	@ManyToOne(fetch = FetchType.EAGER)
	private EUsuario usuario;
	
	public ENotificacao () {}
	
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
	public LocalDate getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(LocalDate dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public EUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(EUsuario usuario) {
		this.usuario = usuario;
	}
	
}
