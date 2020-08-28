package br.com.marcos.matriculascore.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de domínio que representa uma turma
 * @author Marcos Macedo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Turma {
	
	/**
	 * Construtor para criação de turma
	 * @param descricao
	 * @param anoLetivo
	 * @param periodoLetivo
	 * @param numeroVagas
	 */
	public Turma(String descricao, Integer anoLetivo, Integer periodoLetivo, Integer numeroVagas, List<Disciplina> disciplinas, List<Aluno> alunos) {
		this.descricao = descricao;
		this.anoLetivo = anoLetivo;
		this.periodoLetivo = periodoLetivo;
		this.numeroVagas = numeroVagas;
		this.disciplinas = disciplinas;
		this.alunos = alunos;
	}
	
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
