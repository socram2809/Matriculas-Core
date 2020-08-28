package br.com.marcos.matriculascore.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Aluno;
import br.com.marcos.matriculascore.dto.AlunoResponseDTO;
import lombok.Getter;

/**
 * DTO que representa o retorno da criação/alteração de um aluno
 * @author Marcos Macedo
 *
 */
@Getter
public class AlunoResponseDTO extends PessoaResponseDTO {

	private AlunoResponseDTO(Long id, String nome, String email, String cpf, Integer matricula, String formaIngresso) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}

	@NotNull
	private Integer matricula;
	
	@NotBlank
	private String formaIngresso;
	
	public static AlunoResponseDTO transformaEmDTO(Aluno aluno) {
		return new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getMatricula(), aluno.getFormaIngresso());
	}
	
	public static List<AlunoResponseDTO> transformaEmDTO(List<Aluno> alunos) {
		return new ArrayList<>(alunos.stream()
				.map(aluno -> transformaEmDTO(aluno))
				.collect(Collectors.toList()));
	}
}
