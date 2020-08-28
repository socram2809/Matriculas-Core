package br.com.marcos.matriculascore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.marcos.matriculascore.dominio.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO para atualizar professor
 * @author Marcos Macedo
 *
 */
@Getter
@NoArgsConstructor
public class AtualizarProfessorDTO extends AtualizarPessoaDTO implements Serializable {
	
	private static final long serialVersionUID = -3388605856878373789L;
	
	@NotBlank
	private String titulacao;
	
	public AtualizarProfessorDTO(ProfessorResponseDTO professor) {
		this.id = professor.getId();
		this.nome = professor.getNome();
		this.email = professor.getEmail();
		this.cpf = professor.getCpf();
		this.titulacao = professor.getTitulacao();
	}
	
	public Professor transformaParaObjeto() {
		return new Professor(id, nome, email, cpf, titulacao);
	}

}
