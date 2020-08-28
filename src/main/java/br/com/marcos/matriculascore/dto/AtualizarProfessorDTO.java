package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;

import br.com.marcos.matriculascore.dominio.Professor;
import lombok.Getter;

/**
 * DTO para atualizar professor
 * @author Marcos Macedo
 *
 */
@Getter
public class AtualizarProfessorDTO extends AtualizarPessoaDTO {
	
	@NotBlank
	private String titulacao;
	
	public Professor transformaParaObjeto() {
		return new Professor(id, nome, email, cpf, titulacao);
	}

}
