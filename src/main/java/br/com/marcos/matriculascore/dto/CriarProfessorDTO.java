package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;

import br.com.marcos.matriculascore.dominio.Professor;
import lombok.Getter;

/**
 * DTO para criar professor
 * @author Marcos Macedo
 *
 */
@Getter
public class CriarProfessorDTO extends CriarPessoaDTO {
	
	@NotBlank
	private String titulacao;
	
	public Professor transformaParaObjeto() {
		return new Professor(nome, email, cpf, titulacao);
	}
}
