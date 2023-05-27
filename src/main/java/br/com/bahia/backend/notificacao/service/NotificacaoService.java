package br.com.bahia.backend.notificacao.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bahia.backend.notificacao.dto.InsertNotificacaoDTO;
import br.com.bahia.backend.notificacao.entity.ENotificacao;
import br.com.bahia.backend.notificacao.exception.GenericException;
import br.com.bahia.backend.notificacao.repository.ENotificacaoRepository;
import br.com.bahia.backend.notificacao.util.MensagemUtil;
import br.com.bahia.backend.notificacao.util.Validador;

@Service
public class NotificacaoService {

	@Autowired
	private ENotificacaoRepository notificacaoRepository;
	
	public ENotificacao insertNotificacao(InsertNotificacaoDTO dto) {
		
		if(!Validador.valideNotNullAndNotBlank(dto.getCdUsuario())) {
			throw new GenericException(MensagemUtil.USUARIO_NAO_INFORMADO);
		}
		
		ENotificacao notificacao = convertDtoToEntity(dto);
		return notificacaoRepository.save(notificacao);		
	}

	private ENotificacao convertDtoToEntity(InsertNotificacaoDTO dto) {
		
		ENotificacao notificacao = new ENotificacao();
		notificacao.setDtCriacao(LocalDate.now());
		notificacao.setDeMensagem(dto.getDeMensagem());		
		// TODO
		// buscar no banco o usuário a partir do DTO.GETCDUSUARIO e settar na entidade.	
		return notificacao;
	}
	
	
}
