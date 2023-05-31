package br.com.bahia.backend.notificacao.repository;

import br.com.bahia.backend.notificacao.model.EUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EUsuarioRepository extends JpaRepository<Integer, EUsuario> {

}
