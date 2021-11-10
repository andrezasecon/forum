package br.com.andrezasecon.forum.controllers;

import br.com.andrezasecon.forum.domain.Usuario;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc // para conseguir injetar o mockmvc
@AutoConfigureTestEntityManager
@Transactional
@ActiveProfiles("test") // pede ao spring para rodar o profile de teste
class AutenticacaoControllerTest {

    @Autowired(required = true)
    private TestEntityManager em;

    @Autowired
    private MockMvc mockMvc;

        @Test
    void shouldReturnStatus400WhenAuthenticationDataAreIncorrect() throws Exception {

        URI uri = new URI("/auth");
        String json = "{\"email\":\"invalido@gmail.com\", \"senha\":\"123456\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri) // endpoint
                        .content(json) // dados
                        .contentType(MediaType.APPLICATION_JSON)) // tipo de dados
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400)); // status esperado
    }

    @Test
    void shouldReturnStatus200WhenAuthenticationDataAreCorrect() throws Exception {

        String email = "aluno1@gmail.com";
        String senha = "$2a$10$Wl2ilebZeDvPzb3eAeGbgOqVF43rYX2t8RuO.f2fxII./dWv9eO1i";

        Usuario userTest = new Usuario();
        userTest.setEmail(email);
        userTest.setSenha(senha);
        userTest.setNome("teste");
        em.persist(userTest);

        URI uri = new URI("/auth");

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", email);
        jsonObj.put("senha", "123456");
        jsonObj.put("nome", "teste");
        String json = jsonObj.toString();

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri) // endpoint
                        .content(json) // dados
                        .contentType(MediaType.APPLICATION_JSON)) // tipo de dados
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk()); // status esperado
    }
}