package br.com.bahia.backend.notificacao.controller;

import br.com.bahia.backend.notificacao.service.EUsuarioService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eusuario")
@Validated
public class EUsuarioController {

    private final EUsuarioService eUsuarioService;

    public EUsuarioController(EUsuarioService eUsuarioService) {
        this.eUsuarioService = eUsuarioService;
    }

    @PostMapping("/cadastro")
    public EUsuarioDTO cadastrarUsuario(@RequestBody EUsuarioCreateDTO eusuarioCreateDTO) {
        return eUsuarioService.cadastrarUsuario(eusuarioCreateDTO);
    }
}
