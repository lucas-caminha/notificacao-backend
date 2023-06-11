package br.com.bahia.backend.notificacao.security;

import br.com.bahia.backend.notificacao.dto.LoginDTO;
import br.com.bahia.backend.notificacao.entity.EUsuario;
import br.com.bahia.backend.notificacao.exception.GenericException;
import br.com.bahia.backend.notificacao.service.EUsuarioService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    private final EUsuarioService eUsuarioService;
    private final AuthenticationManager authenticaticationManager;

    public AuthenticationService(EUsuarioService eUsuarioService, @Lazy AuthenticationManager authenticaticationManager) {
        this.eUsuarioService = eUsuarioService;
        this.authenticaticationManager = authenticaticationManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EUsuario> usuarioEntityOptional = eUsuarioService.findByLogin(username);
        return usuarioEntityOptional
                .orElseThrow(() -> new UsernameNotFoundException("Usuario inválido!"));
    }

    public EUsuario autenticar(LoginDTO loginDTO) throws GenericException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha());

        Authentication authentication;
        try {
            authentication =
                    authenticaticationManager.authenticate(usernamePasswordAuthenticationToken);

            Object principal = authentication.getPrincipal();
            EUsuario usuario = (EUsuario) principal;

            return usuario;
        } catch (BadCredentialsException ex) {
            throw new GenericException("Usuario não encontrado");
        } catch (DisabledException e) {
            throw new GenericException("Usuário desabilitado!");
        }
    }
}
