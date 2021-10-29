package br.com.andrezasecon.forum.repositories;

import br.com.andrezasecon.forum.domain.Curso;
import br.com.andrezasecon.forum.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CursoRepository extends JpaRepository<Curso, Long> {


    Curso findByNome(String nome);
}
