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
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO para atualizar turma
 * @author Marcos Macedo
 *
 */
@Getter
@NoArgsConstructor
public class AtualizarTurmaDTO implements Serializable {
	
	private static final long serialVersionUID = 5078339488212708185L;

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
	
	public AtualizarTurmaDTO(TurmaResponseDTO turma) {
		this.id = turma.getId();
		this.descricao = turma.getDescricao();
		this.anoLetivo = turma.getAnoLetivo();
		this.periodoLetivo = turma.getPeriodoLetivo();
		this.numeroVagas = turma.getNumeroVagas();
		this.disciplinas = turma.getDisciplinas();
		this.alunos = turma.getAlunos();
	}
	
	public Turma transformaParaObjeto() {
		return new Turma(id, descricao, anoLetivo, periodoLetivo, numeroVagas, 
				disciplinas.stream().map(idDisciplina -> new Disciplina(idDisciplina)).collect(Collectors.toList()), 
				alunos.stream().map(idAluno -> new Aluno(idAluno)).collect(Collectors.toList()));
	}

}
