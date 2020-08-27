package br.com.marcos.matriculascore.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Classe de domínio que representa uma disciplina
 * @author Marcos Macedo
 *
 */
@Data
@Entity
public class Disciplina {
	
	/**
	 * Identificador da disciplina
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Descrição da disciplina
	 */
	private String descricao;
	
	/**
	 * Sigla da disciplina
	 */
	private String sigla;
	
	/**
	 * Carga horária da disciplina
	 */
	private Integer cargaHoraria;
	
	/**
	 * Professor que ministrará a disciplica
	 */
	@ManyToOne
	private Professor professor;
}
