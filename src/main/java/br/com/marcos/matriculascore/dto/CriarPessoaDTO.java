package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

/**
 * DTO para criar pessoa
 * @author Marcos Macedo
 *
 */
@Getter
public abstract class CriarPessoaDTO {
	
	@NotBlank
	protected String nome;
	
	@NotBlank
	protected String email;
	
	@NotBlank
	protected String cpf;
}
