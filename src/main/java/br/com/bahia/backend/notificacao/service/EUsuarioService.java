package br.com.bahia.backend.notificacao.service;

import br.com.bahia.backend.notificacao.dto.EUsuarioCreateDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioUpdateDTO;
import br.com.bahia.backend.notificacao.model.EUsuario;
import br.com.bahia.backend.notificacao.repository.EUsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EUsuarioService {

    private final EUsuarioRepository eUsuarioRepository;
    private final ObjectMapper objectMapper;
//    private final PasswordEncoder passwordEncoder;

    public EUsuarioService(EUsuarioRepository eUsuarioRepository, ObjectMapper objectMapper) {
        this.eUsuarioRepository = eUsuarioRepository;
        this.objectMapper = objectMapper;
    }

    public EUsuarioDTO getEUsuario(Integer idEUsuario){
        return objectMapper.convertValue(eUsuarioRepository.findById(idEUsuario), EUsuarioDTO.class);
    }

    public EUsuarioDTO insertEUsuario(EUsuarioCreateDTO eusuarioCreateDTO){
        EUsuario usuario = objectMapper.convertValue(eusuarioCreateDTO, EUsuario.class);
//        usuario.setSenha(passwordEncoder.encode(eusuarioCreateDTO.getSenha()));
        usuario.setDtCriacao(LocalDate.now());
        EUsuario usuarioSalvo = eUsuarioRepository.save(usuario);
        return objectMapper.convertValue(usuarioSalvo, EUsuarioDTO.class);
    }

    public EUsuarioDTO updateEUsuario(Integer idEUsuario, EUsuarioUpdateDTO eusuarioUpdateDTO){
        EUsuario usuario = eUsuarioRepository.getReferenceById(idEUsuario);
        usuario.setNmUsuario(eusuarioUpdateDTO.getNmUsuario());
        EUsuario usuarioAtualizado = eUsuarioRepository.save(usuario);
        return objectMapper.convertValue(usuarioAtualizado, EUsuarioDTO.class);
    }

    public void deleteEUsuario(Integer idEUsuario){
        eUsuarioRepository.deleteById(idEUsuario);
    }
}