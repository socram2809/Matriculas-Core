package br.com.marcos.matriculascore.dto;

import java.io.Serializable;

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
public class AtualizarAlunoDTO extends AtualizarPessoaDTO implements Serializable {
	
	private static final long serialVersionUID = -6738226547302018093L;

	@NotNull
	private Integer matricula;
	
	@NotBlank
	private String formaIngresso;
	
	public AtualizarAlunoDTO(AlunoResponseDTO aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.cpf = aluno.getCpf();
		this.matricula = aluno.getMatricula();
		this.formaIngresso = aluno.getFormaIngresso();
	}
	
	public Aluno transformaParaObjeto() {
		return new Aluno(id, nome, email, cpf, matricula, formaIngresso);
	}

}
