package br.com.andrezasecon.forum.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;

}
