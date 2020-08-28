package br.com.marcos.matriculascore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

/**
 * DTO para atualizar pessoa
 * @author Marcos Macedo
 *
 */
@Getter
public abstract class AtualizarPessoaDTO implements Serializable {
	
	private static final long serialVersionUID = 3402613315983496789L;

	@NotNull
	protected Long id;
	
	@NotBlank
	protected String nome;
	
	@NotBlank
	protected String email;
	
	@NotBlank
	protected String cpf;

}
