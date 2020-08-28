package br.com.marcos.matriculascore.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de domínio que representa uma disciplina
 * @author Marcos Macedo
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Disciplina {
	
	/**
	 * Construtor para relacionamentos
	 * @param id
	 */
	public Disciplina(Long id) {
		this.id = id;
	}
	
	/**
	 * Construtor para criação de disciplina
	 * @param descricao
	 * @param sigla
	 * @param cargaHoraria
	 */
	public Disciplina(String descricao, String sigla, Integer cargaHoraria, Professor professor) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}
	
	/**
	 * Construtor para alteração de disciplina
	 * @param id
	 * @param descricao
	 * @param sigla
	 * @param cargaHoraria
	 */
	public Disciplina(Long id, String descricao, String sigla, Integer cargaHoraria, Professor professor) {
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}
	
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
	@ManyToOne(optional = false)
	private Professor professor;
}
