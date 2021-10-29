package br.com.andrezasecon.forum.dto;

import br.com.andrezasecon.forum.domain.Topico;
import br.com.andrezasecon.forum.repositories.TopicoRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class AtualizacaoTopicoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 100)
    private String titulo;

    @NotNull @NotEmpty @Length(min = 10, max = 500)
    private String mensagem;
    private String nomeCurso;

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getById(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }
}
