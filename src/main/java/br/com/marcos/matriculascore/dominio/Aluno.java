package br.com.marcos.matriculascore.dominio;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe de domínio que representa um aluno
 * @author Marcos Macedo
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class Aluno extends Pessoa {
	
	/**
	 * Construtor para relacionamentos
	 * @param id
	 */
	public Aluno(Long id) {
		this.id = id;
	}
	
	/**
	 * Construtor para alteração de aluno
	 * @param id
	 * @param nome
	 * @param email
	 * @param cpf
	 * @param matricula
	 * @param formaIngresso
	 */
	public Aluno(Long id, String nome, String email, String cpf, Integer matricula, String formaIngresso) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}
	
	/**
	 * Construtor para criação de aluno
	 * @param nome
	 * @param email
	 * @param cpf
	 * @param matricula
	 * @param formaIngresso
	 */
	public Aluno(String nome, String email, String cpf, Integer matricula, String formaIngresso) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}

	/**
	 * Matrícula do aluno
	 */
	private Integer matricula;
	
	/**
	 * Forma de Ingresso (ENADE, Vestibular) do aluno
	 */
	private String formaIngresso;
}
