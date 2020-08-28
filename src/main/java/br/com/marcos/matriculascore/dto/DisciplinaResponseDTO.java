package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Disciplina;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO que representa a resposta da criação/alteração de disciplina
 * @author Marcos Macedo
 *
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DisciplinaResponseDTO {

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
	
	public static DisciplinaResponseDTO transformaEmDTO(Disciplina disciplina) {
		return new DisciplinaResponseDTO(disciplina.getId(), disciplina.getDescricao(), disciplina.getSigla(), disciplina.getCargaHoraria(), disciplina.getProfessor().getId());
	}
}
