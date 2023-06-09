package br.com.bahia.backend.notificacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EUsuarioCreateDTO {

    @NotBlank(message = "É necessário informar um nome!")
    @Schema(example = "Monolítico")
    private String nmUsuario;

    @NotBlank(message = "É necessário informar um login!")
    @Email
    @Schema(example = "email@email.com")
    private String email;

    @NotBlank(message = "É necessário informar uma senha!")
    @Schema(example = "123456789")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
