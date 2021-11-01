package br.com.andrezasecon.forum.repositories;

import br.com.andrezasecon.forum.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CursoRepository extends JpaRepository<Curso, Long> {


    Curso findByNome(String nome);
}
