package br.com.andrezasecon.forum.repositories;

import br.com.andrezasecon.forum.domain.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest   //Roda no H2 por padrão, se quiser rodar banco de prod, tem q informar ao Spring para q ele não substitua as configs de banco
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") // pede ao spring para rodar o profile de teste
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Autowired // utilizado para popular o banco da aplicação q estiver vazio
    private TestEntityManager em;

    @Test
    public void ShouldReturnNameWhenFindCursoByNome() {

        String nomeCurso = "HTML5";

        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programação");
        em.persist(html5);

        Curso curso = repository.findByNome(nomeCurso);
        Assertions.assertNotNull(curso);
        Assertions.assertEquals(nomeCurso, curso.getNome());

    }

    @Test
    public void ShouldNotReturnNameWhenFindCursoByNome() {
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);
        Assertions.assertNull(curso);

    }
}