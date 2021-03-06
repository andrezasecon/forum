package br.com.andrezasecon.forum.config.security;

import br.com.andrezasecon.forum.domain.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
       Usuario logado = (Usuario) authentication.getPrincipal();
       Date hoje = new Date();
       Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration)); // soma a data de geração com a data de expiração do token
        return Jwts.builder()
                .setIssuer("API fórum") // quem gerou o token
                .setSubject(logado.getId().toString()) // usuário que é dono do token
                .setIssuedAt(hoje) // quando foi gerado o token
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // recupera o id do usuário contido no token
    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
