package br.com.andrezasecon.forum.repositories;

import br.com.andrezasecon.forum.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Para fazer a busca por relacionamento só colocar após o findBy o nome da entidade e o compo
    // se ouver ambiquidade com atributo da classe topico utilizar o _ para o spring diferencias
    List<Topico> findByCursoNome(String nomeCurso);
    //List<Topico> findByCurso_Nome(String nomeCurso);
    // podemos montar o método com o nome q preferirmos, desde q façamos a query na mão
}
