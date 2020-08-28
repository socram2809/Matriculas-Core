package br.com.marcos.matriculascore.dominio;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe de domínio que representa um professor
 * @author Marcos Macedo
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Entity
public class Professor extends Pessoa {
	
	/**
	 * Construtor para relacionamentos
	 * @param id
	 */
	public Professor(Long id) {
		this.id = id;
	}
	
	/**
	 * Construtor para alteração de professor
	 * @param id
	 * @param nome
	 * @param email
	 * @param cpf
	 * @param titulacao
	 */
	public Professor(Long id, String nome, String email, String cpf, String titulacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.titulacao = titulacao;
	}
	
	/**
	 * Construtor para criação de professor
	 * @param nome
	 * @param email
	 * @param cpf
	 * @param titulacao
	 */
	public Professor(String nome, String email, String cpf, String titulacao) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.titulacao = titulacao;
	}

	/**
	 * Titulação (mestre, doutor, PHD) do professor
	 */
	private String titulacao;
}
