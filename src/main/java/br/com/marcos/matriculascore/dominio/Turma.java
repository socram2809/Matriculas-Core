package br.com.marcos.matriculascore.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * Classe de domínio que representa uma turma
 * @author Marcos Macedo
 *
 */
@Data
@Entity
public class Turma {
	
	/**
	 * Identificador da turma
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Descrição da turma
	 */
	private String descricao;
	
	/**
	 * Ano Letivo da Turma
	 */
	private Integer anoLetivo;
	
	/**
	 * Período Letivo da Turma
	 */
	private Integer periodoLetivo;
	
	/**
	 * Número de Vagas da Turma
	 */
	private Integer numeroVagas;
	
	/**
	 * Disciplinas da Turma
	 */
	@ManyToMany
	@JoinTable(name = "turma_disciplinas")
	private List<Disciplina> disciplinas;
	
	/**
	 * Alunos da Turma
	 */
	@ManyToMany
	@JoinTable(name = "turma_alunos")
	private List<Aluno> alunos;
}
