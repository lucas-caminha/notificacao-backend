package br.com.bahia.backend.notificacao.controller;

import br.com.bahia.backend.notificacao.doc.EUsuarioDoc;
import br.com.bahia.backend.notificacao.dto.EUsuarioCreateDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioUpdateDTO;
import br.com.bahia.backend.notificacao.service.EUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class EUsuarioController implements EUsuarioDoc {

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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EUsuarioDTO> updateEUsuario(@PathVariable("id") Integer idEUsuario, @RequestBody EUsuarioUpdateDTO eusuarioUpdateDTO) {
        return new ResponseEntity<>(eUsuarioService.updateEUsuario(idEUsuario, eusuarioUpdateDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEUsuario(@PathVariable("id") Integer idEUsuario) {
        eUsuarioService.deleteEUsuario(idEUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}