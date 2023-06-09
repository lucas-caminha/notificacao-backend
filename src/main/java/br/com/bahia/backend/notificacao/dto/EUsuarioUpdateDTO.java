package br.com.bahia.backend.notificacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class EUsuarioUpdateDTO {

    @Schema(example = "Micro")
    private String nmUsuario;


    public EUsuarioUpdateDTO() {
    }

    public EUsuarioUpdateDTO(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }
}