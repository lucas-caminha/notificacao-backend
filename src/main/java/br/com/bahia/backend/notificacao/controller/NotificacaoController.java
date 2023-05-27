package br.com.bahia.backend.notificacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bahia.backend.notificacao.dto.InsertNotificacaoDTO;
import br.com.bahia.backend.notificacao.entity.ENotificacao;
import br.com.bahia.backend.notificacao.service.NotificacaoService;

@RestController
@RequestMapping(value = "/notificacao")
public class NotificacaoController {

	@Autowired
	private NotificacaoService notificacaoService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<ENotificacao> insertNotificacao(@RequestBody InsertNotificacaoDTO notificacao) {
		ENotificacao insertNotificacao = notificacaoService.insertNotificacao(notificacao);
		return new ResponseEntity<ENotificacao>(insertNotificacao, HttpStatus.CREATED);
	}
	
	
	
}
