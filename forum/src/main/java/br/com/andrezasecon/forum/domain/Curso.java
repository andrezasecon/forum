package br.com.andrezasecon.forum.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_curso")
@Data
@NoArgsConstructor
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String categoria;

	public Curso(String nome, String categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}

	public Curso(Curso nomeCurso) {
		this.nome = nomeCurso.getNome();
	}
}