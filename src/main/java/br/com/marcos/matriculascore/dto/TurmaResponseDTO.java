package br.com.marcos.matriculascore.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Aluno;
import br.com.marcos.matriculascore.dominio.Disciplina;
import br.com.marcos.matriculascore.dominio.Turma;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO que representa a resposta da criaçao/alteração de turma
 * @author Marcos Macedo
 *
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TurmaResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 4L;

	@NotNull
	private Long id;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private Integer anoLetivo;
	
	@NotNull
	private Integer periodoLetivo;
	
	@NotNull
	private Integer numeroVagas;
	
	@NotEmpty
	private List<Long> disciplinas;
	
	@NotEmpty
	private List<Long> alunos;
	
	public static TurmaResponseDTO transformaEmDTO(Turma turma) {
		return new TurmaResponseDTO(turma.getId(), turma.getDescricao(), turma.getAnoLetivo(), turma.getPeriodoLetivo(), turma.getNumeroVagas(), 
				turma.getDisciplinas().stream().mapToLong(Disciplina::getId).boxed().collect(Collectors.toList()), 
				turma.getAlunos().stream().mapToLong(Aluno::getId).boxed().collect(Collectors.toList()));
	}
}
