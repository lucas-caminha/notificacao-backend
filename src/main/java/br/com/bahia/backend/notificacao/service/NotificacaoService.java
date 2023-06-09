package br.com.bahia.backend.notificacao.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bahia.backend.notificacao.dto.DeleteNotificacaoDTO;
import br.com.bahia.backend.notificacao.dto.InsertNotificacaoDTO;
import br.com.bahia.backend.notificacao.dto.UpdateNotificacaoDTO;
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
	
	public ENotificacao updateNotificacao(UpdateNotificacaoDTO dto) {	
		if(!Validador.valideNotNullAndNotBlank(dto.getCdNotificacao())) {
			throw new GenericException(MensagemUtil.CODIGO_NOTIFICACAO_NAO_INFORMADO);
		}
		
		ENotificacao notificacao = findNotificacao(dto.getCdNotificacao());
		notificacao.setDeMensagem(dto.getDeMensagem());
		notificacao.setDtCriacao(LocalDate.now());
		return notificacaoRepository.save(notificacao);
	}
	
	
	public ENotificacao deleteNotificacao(DeleteNotificacaoDTO dto) {
		ENotificacao findNotificacao = findNotificacao(dto.getCdNotificacao());
		notificacaoRepository.delete(findNotificacao);
		return findNotificacao;
	}

	public ENotificacao findNotificacao(Integer cdNotificacao) {
		Optional<ENotificacao> notificacao = notificacaoRepository.findById(cdNotificacao);
		if(notificacao.isPresent()) {
			return notificacao.get();
		}
		throw new GenericException(MensagemUtil.NOTIFICACAO_NAO_ENCONTRADA);
	}

	private ENotificacao convertDtoToEntity(InsertNotificacaoDTO dto) {		
		ENotificacao notificacao = new ENotificacao();
		notificacao.setDtCriacao(LocalDate.now());
		notificacao.setDeMensagem(dto.getDeMensagem());		
		// TODO
		// buscar no banco o usuário a partir do DTO.GETCDUSUARIO e settar na entidade.	
		return notificacao;
	}

	public List<ENotificacao> findAllNotificacoes() {
		return notificacaoRepository.findAll();
	}

}
