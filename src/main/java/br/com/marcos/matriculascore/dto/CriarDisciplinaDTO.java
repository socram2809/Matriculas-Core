package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Disciplina;
import br.com.marcos.matriculascore.dominio.Professor;
import lombok.Getter;

/**
 * DTO para criar disciplina
 * @author Marcos Macedo
 *
 */
@Getter
public class CriarDisciplinaDTO {
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String sigla;
	
	@NotNull
	private Integer cargaHoraria;
	
	@NotNull
	private Long idProfessor;
	
	public Disciplina transformaParaObjeto() {
		return new Disciplina(descricao, sigla, cargaHoraria, new Professor(idProfessor));
	}
}
