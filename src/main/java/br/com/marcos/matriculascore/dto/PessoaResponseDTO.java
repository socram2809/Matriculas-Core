package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

/**
 * DTO que representa o retorno da criação/alteração de pessoa
 * @author Marcos Macedo
 *
 */
@Getter
public abstract class PessoaResponseDTO {
	
	@NotNull
	protected Long id;

	@NotBlank
	protected String nome;
	
	@NotBlank
	protected String email;
	
	@NotBlank
	protected String cpf;
}
