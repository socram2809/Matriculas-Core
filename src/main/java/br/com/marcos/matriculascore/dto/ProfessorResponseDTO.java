package br.com.marcos.matriculascore.dto;

import javax.validation.constraints.NotBlank;

import br.com.marcos.matriculascore.dominio.Professor;
import lombok.Getter;

/**
 * DTO que representa o retorno da criação/alteração de um professor
 * @author Marcos Macedo
 *
 */
@Getter
public class ProfessorResponseDTO extends PessoaResponseDTO {

	private ProfessorResponseDTO(Long id, String nome, String email, String cpf, String titulacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.titulacao = titulacao;
	}

	@NotBlank
	private String titulacao;
	
	public static ProfessorResponseDTO transformaEmDTO(Professor professor) {
		return new ProfessorResponseDTO(professor.getId(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getTitulacao());
	}
}
