package br.com.bahia.backend.notificacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bahia.backend.notificacao.dto.DeleteNotificacaoDTO;
import br.com.bahia.backend.notificacao.dto.InsertNotificacaoDTO;
import br.com.bahia.backend.notificacao.dto.UpdateNotificacaoDTO;
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
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<ENotificacao> updateNotificacao(@RequestBody UpdateNotificacaoDTO notificacao) {
		ENotificacao updateNotificacao = notificacaoService.updateNotificacao(notificacao);
		return new ResponseEntity<ENotificacao>(updateNotificacao, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<ENotificacao> insertNotificacao(@RequestBody DeleteNotificacaoDTO notificacao) {
		ENotificacao deleteNotificacao = notificacaoService.deleteNotificacao(notificacao);
		return new ResponseEntity<ENotificacao>(deleteNotificacao, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<ENotificacao>> listNotificacoes() {
		List<ENotificacao> listNotificacoes = notificacaoService.findAllNotificacoes();
		return new ResponseEntity<List<ENotificacao>>(listNotificacoes, HttpStatus.OK);
	}
	
}
