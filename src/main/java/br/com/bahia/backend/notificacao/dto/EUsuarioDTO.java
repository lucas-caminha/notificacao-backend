package br.com.bahia.backend.notificacao.dto;

import java.time.LocalDate;

public class EUsuarioDTO {

    private Integer cdUsuario;
    private String nmUsuario;
    private String email;
    private LocalDate dtCriacao;


    public EUsuarioDTO() {
    }

    public EUsuarioDTO(Integer cdUsuario, String nmUsuario, String email, LocalDate dtCriacao) {
        this.cdUsuario = cdUsuario;
        this.nmUsuario = nmUsuario;
        this.email = email;
        this.dtCriacao = dtCriacao;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
}
