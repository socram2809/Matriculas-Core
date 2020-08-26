package br.com.marcos.matriculascore.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * Classe abstrata que representa uma pessoa
 * @author Marcos Macedo
 *
 */
@Data
@MappedSuperclass
public abstract class Pessoa {
	
	/**
	 * Identificador da pessoa
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/**
	 * Nome da pessoa
	 */
	protected String nome;
	
	/**
	 * E-mail da pessoa
	 */
	protected String email;
	
	/**
	 * CPF da pessoa
	 */
	protected String cpf;
}
