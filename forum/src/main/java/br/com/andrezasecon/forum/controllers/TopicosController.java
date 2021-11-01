package br.com.andrezasecon.forum.controllers;

import br.com.andrezasecon.forum.domain.Topico;
import br.com.andrezasecon.forum.dto.AtualizacaoTopicoForm;
import br.com.andrezasecon.forum.dto.DetalhesDoTopicoDto;
import br.com.andrezasecon.forum.dto.TopicoDto;
import br.com.andrezasecon.forum.dto.TopicoForm;
import br.com.andrezasecon.forum.repositories.CursoRepository;
import br.com.andrezasecon.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
            return TopicoDto.converter(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCursoNomeIgnoreCaseContaining(nomeCurso); // busca com parametros
            return TopicoDto.converter(topicos);
        }
    }

    // o @RequestBody avisa ao spring que os dados serão enviados no corpo da mensagem
    // passando o UriComponents como parametro, ele já pega o caminho do método
    @Transactional // commita a operação
    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id){
       Optional<Topico> topico = topicoRepository.findById(id);
       if(topico.isPresent()) {
           return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
       }
       return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional // faz o JPA commitar a transação no banco de dados
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
       Optional<Topico> optional = topicoRepository.findById(id);
       if(optional.isPresent()) {
           Topico topico = form.atualizar(id, topicoRepository);
           return ResponseEntity.ok(new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Topico> optional = topicoRepository.findById(id);
        if(optional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
