package br.com.andrezasecon.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // habilita security na aplicação
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // configurações de autenticação/controle de acesso
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // configurações de autorização / perfil de acesso a URL
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/topicos").permitAll()
                .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated() // qualquer outro verbo http deve estar autenticado
                //.and().formLogin(); // formulario de login do spring
                .and().csrf().disable() // desabilita o cross site request forgery (montagem de sessão)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // avisa ao spring para não gerar sessão de autenticação

    }

    // configurações de recursos estáticos, requisições JS, CSS, IMG, etc
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

//    PARA GERAR SENHA COM O Bcrypt
//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//    }

}
