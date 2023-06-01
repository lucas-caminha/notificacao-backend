package br.com.bahia.backend.notificacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EUsuarioCreateDTO {

    @NotBlank
    @Schema(example = "Monolítico")
    private String nmUsuario;

    @NotBlank
    @Email
    @Schema(example = "email@email.com")
    private String email;

    @NotBlank
    @Schema(example = "123456789")
    private String senha;


    public EUsuarioCreateDTO(){

    }

    public EUsuarioCreateDTO(String nmUsuario, String email, String senha) {
        this.nmUsuario = nmUsuario;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
