package br.com.andrezasecon.forum.config.security;

import br.com.andrezasecon.forum.repositories.UsuarioRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRepository repository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = recuperarToken(request);
        System.out.println(token);

        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
       String token = request.getHeader("Authorization");
       if (token == null || token.isEmpty() || !token.startsWith("Bearer ") ){
           return null;
       }
       return token.substring(7, token.length());
    }
}
