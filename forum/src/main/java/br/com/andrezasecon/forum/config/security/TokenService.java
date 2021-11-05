package br.com.andrezasecon.forum.config.security;

import br.com.andrezasecon.forum.domain.Usuario;
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
                .setIssuer("API do fórum") // quem gerou o token
                .setSubject(logado.getId().toString()) // usuário que é dono do token
                .setIssuedAt(hoje) // quando foi gerado o token
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
