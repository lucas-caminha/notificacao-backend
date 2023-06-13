package br.com.bahia.backend.notificacao.security;

import br.com.bahia.backend.notificacao.entity.EUsuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expiration;
    private static final String CARGOS_CHAVE = "cargos";

    public String gerarToken(EUsuario usuario) {
        Date now = Date.valueOf(LocalDate.now());
        Date dateExpiration = new Date(now.getTime() + Long.parseLong(expiration));

//        List<String> cargos = usuario.getAuthorities().stream()
//                .map(grantedAuthority -> grantedAuthority.getAuthority())
//                .collect(Collectors.toList());

        String meuToken = Jwts.builder()
                .claim("email", usuario.getEmail())
                .claim(Claims.ID, String.valueOf(usuario.getCdUsuario()))
//                .claim(CARGOS_CHAVE, cargos)
                .setIssuedAt(now)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return meuToken;
    }

    public UsernamePasswordAuthenticationToken isValid(String meuToken) {
        try {
            if (meuToken == null) {
                return null;
            }
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(meuToken)
                    .getBody();
            String user = body.get(Claims.ID, String.class);
            if (user != null) {

//                List<String> cargos = body.get(CARGOS_CHAVE, List.class);
//                List<SimpleGrantedAuthority> cargosDoUsuario = cargos.stream()
//                        .map(authority -> new SimpleGrantedAuthority(authority))
//                        .collect(Collectors.toList());

                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<SimpleGrantedAuthority>());
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
