package br.com.bahia.backend.test;

import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.bahia.backend.notificacao.controller.NotificacaoController;
import br.com.bahia.backend.notificacao.dto.InsertNotificacaoDTO;
import br.com.bahia.backend.notificacao.entity.ENotificacao;

@RunWith(SpringRunner.class)
@WebMvcTest(NotificacaoController.class)
public class NotificacaoControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private NotificacaoController notificacaoController;
	
	@Test
	public void insertNotificacaoDeveRetornar201Created() {
		InsertNotificacaoDTO dto = new InsertNotificacaoDTO();
		dto.setCdUsuario(1);
		dto.setDeMensagem("Testando insert de notificacao");
		
		ResponseEntity<ENotificacao> response = new ResponseEntity<ENotificacao>(HttpStatus.CREATED);
		given(notificacaoController.insertNotificacao(dto)).willReturn(response);
		
	}
	

	
	
}
