package br.com.andrezasecon.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // habilita security na aplicação
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    // configurações de autenticação/controle de acesso
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    // configurações de autorização / perfil de acesso a URL
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/topicos").permitAll()
                .antMatchers(HttpMethod.GET, "/topicos/*").permitAll();

    }

    // configurações de recursos estáticos, requisições JS, CSS, IMG, etc
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
