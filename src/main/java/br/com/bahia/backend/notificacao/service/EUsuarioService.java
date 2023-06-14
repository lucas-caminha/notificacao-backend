package br.com.bahia.backend.notificacao.service;

import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.bahia.backend.notificacao.dto.EUsuarioCreateDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioDTO;
import br.com.bahia.backend.notificacao.dto.EUsuarioUpdateDTO;
import br.com.bahia.backend.notificacao.entity.EUsuario;
import br.com.bahia.backend.notificacao.repository.EUsuarioRepository;

@Service
public class EUsuarioService {

    private final EUsuarioRepository eUsuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    public EUsuarioService(EUsuarioRepository eUsuarioRepository, PasswordEncoder passwordEncoder, ObjectMapper objectMapper) {
        this.eUsuarioRepository = eUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.objectMapper = objectMapper;
    }

    public EUsuarioDTO getEUsuario(Integer idEUsuario){
        return objectMapper.convertValue(eUsuarioRepository.findById(idEUsuario), EUsuarioDTO.class);
    }

    public EUsuarioDTO insertEUsuario(EUsuarioCreateDTO eusuarioCreateDTO){
        EUsuario usuario = objectMapper.convertValue(eusuarioCreateDTO, EUsuario.class);
        usuario.setSenha(passwordEncoder.encode(eusuarioCreateDTO.getSenha()));
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

    public Optional<EUsuario> findByLogin (String login) {
        return eUsuarioRepository.findByEmail(login);
    }

    public void deleteEUsuario(Integer idEUsuario){
        eUsuarioRepository.deleteById(idEUsuario);
    }
}
