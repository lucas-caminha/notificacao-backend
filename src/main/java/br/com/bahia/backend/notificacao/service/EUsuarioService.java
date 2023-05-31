package br.com.bahia.backend.notificacao.service;

import br.com.bahia.backend.notificacao.dto.EUsuarioCreateDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDeleteDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioUpdateDTO;
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

    public EUsuarioDTO getEUsuario(Integer idEUsuario){
        //
        return new EUsuarioDTO();
    }

    public EUsuarioDTO insertEUsuario(EUsuarioCreateDTO eusuarioCreateDTO){
        EUsuario usuario = objectMapper.convertValue(eusuarioCreateDTO, EUsuario.class);
        return objectMapper.convertValue(eUsuarioRepository.save(usuario), EUsuarioDTO.class);
    }

    public EUsuarioDTO updateEUsuario(EUsuarioUpdateDTO eusuarioUpdateDTO){
       //
        return new EUsuarioDTO();
    }

    public EUsuarioDTO deleteEUsuario(EUsuarioDeleteDTO eusuarioDeleteDTO){
        //
        return new EUsuarioDTO();
    }
}
