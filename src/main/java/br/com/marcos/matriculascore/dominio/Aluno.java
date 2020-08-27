package br.com.marcos.matriculascore.dominio;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe de domínio que representa um aluno
 * @author Marcos Macedo
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Aluno extends Pessoa {

	/**
	 * Matrícula do aluno
	 */
	private Integer matricula;
	
	/**
	 * Forma de Ingresso (ENADE, Vestibular) do aluno
	 */
	private String formaIngresso;
}
