package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Aluno;
import lombok.Getter;

/**
 * DTO para atualizar aluno
 * @author Marcos Macedo
 *
 */
@Getter
public class AtualizarAlunoDTO extends AtualizarPessoaDTO {
	
	@NotNull
	private Integer matricula;
	
	@NotBlank
	private String formaIngresso;
	
	public Aluno transformaParaObjeto() {
		return new Aluno(id, nome, email, cpf, matricula, formaIngresso);
	}

}
