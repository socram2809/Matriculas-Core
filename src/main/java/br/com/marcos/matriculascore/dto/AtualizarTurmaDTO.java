package br.com.marcos.matriculascore.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Aluno;
import br.com.marcos.matriculascore.dominio.Disciplina;
import br.com.marcos.matriculascore.dominio.Turma;
import lombok.Getter;

/**
 * DTO para atualizar turma
 * @author Marcos Macedo
 *
 */
@Getter
public class AtualizarTurmaDTO {
	
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
	
	public Turma transformaParaObjeto() {
		return new Turma(id, descricao, anoLetivo, periodoLetivo, numeroVagas, 
				disciplinas.stream().map(idDisciplina -> new Disciplina(idDisciplina)).collect(Collectors.toList()), 
				alunos.stream().map(idAluno -> new Aluno(idAluno)).collect(Collectors.toList()));
	}

}
