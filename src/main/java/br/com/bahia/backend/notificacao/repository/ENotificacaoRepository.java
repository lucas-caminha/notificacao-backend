package br.com.bahia.backend.notificacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bahia.backend.notificacao.entity.ENotificacao;

public interface ENotificacaoRepository extends JpaRepository<ENotificacao, Integer>{

}
