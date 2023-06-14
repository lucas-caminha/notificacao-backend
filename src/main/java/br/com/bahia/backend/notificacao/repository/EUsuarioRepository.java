package br.com.bahia.backend.notificacao.repository;

import br.com.bahia.backend.notificacao.entity.EUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EUsuarioRepository extends JpaRepository<EUsuario, Integer> {

    Optional<EUsuario> findByEmail(String login);
}
