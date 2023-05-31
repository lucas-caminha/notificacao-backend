package br.com.bahia.backend.notificacao.service;

import br.com.bahia.backend.notificacao.model.EUsuario;
import br.com.bahia.backend.notificacao.repository.EUsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class EUsuarioService {

    private final EUsuarioRepository eUsuarioRepository;
    private final ObjectMapper objectMapper;


    public EUsuarioService(EUsuarioRepository eUsuarioRepository, ObjectMapper objectMapper) {
        this.eUsuarioRepository = eUsuarioRepository;
        this.objectMapper = objectMapper;
    }

    public EUsuarioDTO cadastrarUsuario(EUsuarioCreateDTO eusuarioCreateDTO){
        EUsuario usuario = objectMapper.convertValue(eusuarioCreateDTO, EUsuario.class);
        return eUsuarioRepository.save(usuario);
    }
}
