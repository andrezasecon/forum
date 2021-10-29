package br.com.andrezasecon.forum.controllers;

import br.com.andrezasecon.forum.domain.Topico;
import br.com.andrezasecon.forum.dto.DetalhesDoTopicoDto;
import br.com.andrezasecon.forum.dto.TopicoDto;
import br.com.andrezasecon.forum.dto.TopicoForm;
import br.com.andrezasecon.forum.repositories.CursoRepository;
import br.com.andrezasecon.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.net.URI;
import java.util.List;

@RestController // Adiciona automaticamente o @ResponseBody em cada método
@RequestMapping(value = "/topicos")
public class TopicosController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping // por padrão os parametros serão enviados na URL
    public List<TopicoDto> list(String nomeCurso){
        if(nomeCurso == null){
            List<Topico> topicos = topicoRepository.findAll(); //Busca sem parametros
            return TopicoDto.convert(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCursoNomeIgnoreCaseContaining(nomeCurso); // busca com parametros
            return TopicoDto.convert(topicos);
        }
    }

    @PostMapping  // o @RequestBody avisa ao spring que os dados serão enviados no corpo da mensagem
    // passando o UriComponents como parametro, ele já pega o caminho do método
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
        Topico topico = topicoForm.convert(cursoRepository);
        topicoRepository.save(topico);

        // Na URI adicionamos o caminho do novo recurso criado, o spring adicina esse location na cabeçalho da resposta
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico)); // na semantica do 201 created, na resposta temos que passar a URI

    }

    @GetMapping("/{id}")
    public DetalhesDoTopicoDto detail(@PathVariable Long id){
        Topico topico = topicoRepository.getById(id);
        return new DetalhesDoTopicoDto(topico);
    }

}
