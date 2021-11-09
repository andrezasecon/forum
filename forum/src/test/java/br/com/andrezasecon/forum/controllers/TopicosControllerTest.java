package br.com.andrezasecon.forum.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest // carrega no contexto somente MVC (controlers)
@ActiveProfiles("test") // pede ao spring para rodar o profile de teste
class TopicosControllerTest {

    @Test
    void list() {
    }

    @Test
    void cadastrar() {
    }

    @Test
    void detalhar() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void remover() {
    }
}