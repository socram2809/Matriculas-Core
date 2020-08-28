package br.com.marcos.matriculascore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Disciplina;
import br.com.marcos.matriculascore.dominio.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO para atualizar disciplina
 * @author Marcos Macedo
 *
 */
@Getter
@NoArgsConstructor
public class AtualizarDisciplinaDTO implements Serializable {
	
	private static final long serialVersionUID = -5355444507599503678L;

	@NotNull
	private Long id;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String sigla;
	
	@NotNull
	private Integer cargaHoraria;
	
	@NotNull
	private Long idProfessor;
	
	public AtualizarDisciplinaDTO(DisciplinaResponseDTO disciplina) {
		this.id = disciplina.getId();
		this.descricao = disciplina.getDescricao();
		this.sigla = disciplina.getSigla();
		this.cargaHoraria = disciplina.getCargaHoraria();
		this.idProfessor = disciplina.getIdProfessor();
	}
	
	public Disciplina transformaParaObjeto() {
		return new Disciplina(id, descricao, sigla, cargaHoraria, new Professor(idProfessor));
	}

}
