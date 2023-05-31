package br.com.bahia.backend.notificacao.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eusuario")
@Validated
public class EUsuarioController {

    public EusuarioDTO cadastrarUsuario(EUsuarioCreateDTO eusuarioCreateDTO) {

    }
}
