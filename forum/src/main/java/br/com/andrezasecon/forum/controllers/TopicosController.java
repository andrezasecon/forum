package br.com.andrezasecon.forum.controllers;

import br.com.andrezasecon.forum.domain.Topico;
import br.com.andrezasecon.forum.dto.TopicoDto;
import br.com.andrezasecon.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController // Adiciona automaticamente o @ResponseBody em cada método
@RequestMapping(value = "/forum")
public class TopicosController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping("/topicos")
    public List<TopicoDto> list(String nomeCurso){
        if(nomeCurso == null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.convert(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.convert(topicos);
        }
    }

}
