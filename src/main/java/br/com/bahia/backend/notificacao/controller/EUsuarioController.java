package br.com.bahia.backend.notificacao.controller;

import br.com.bahia.backend.notificacao.dto.EUsuarioCreateDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDeleteDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioUpdateDTO;
import br.com.bahia.backend.notificacao.service.EUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eusuario")
public class EUsuarioController {

    private final EUsuarioService eUsuarioService;

    public EUsuarioController(EUsuarioService eUsuarioService) {
        this.eUsuarioService = eUsuarioService;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<EUsuarioDTO> getEUsuario(@PathVariable("id") Integer idEUsuario) {
        return new ResponseEntity<>(eUsuarioService.getEUsuario(idEUsuario), HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<EUsuarioDTO> insertEUsuario(@RequestBody EUsuarioCreateDTO eusuarioCreateDTO) {
        return new ResponseEntity<>(eUsuarioService.insertEUsuario(eusuarioCreateDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<EUsuarioDTO> updateEUsuario(@RequestBody EUsuarioUpdateDTO eusuarioUpdateDTO) {
        return new ResponseEntity<>(eUsuarioService.updateEUsuario(eusuarioUpdateDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<EUsuarioDTO> deleteEUsuario(@RequestBody EUsuarioDeleteDTO eusuarioDeleteDTO) {
        return new ResponseEntity<>(eUsuarioService.deleteEUsuario(eusuarioDeleteDTO), HttpStatus.OK);
    }
}
