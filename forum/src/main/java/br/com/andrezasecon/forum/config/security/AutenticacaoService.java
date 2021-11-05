package br.com.andrezasecon.forum.config.security;

import br.com.andrezasecon.forum.domain.Usuario;
import br.com.andrezasecon.forum.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <Usuario> usuario = usuarioRepository.findByEmail(username);
        if(usuario.isPresent()){
            return usuario.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }
}
