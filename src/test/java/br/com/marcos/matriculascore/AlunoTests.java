package br.com.marcos.matriculascore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.marcos.matriculascore.dominio.Aluno;
import br.com.marcos.matriculascore.repository.AlunoRepository;

/**
 * Classe para realizar testes de CRUD em Aluno
 * @author Marcos Macedo
 *
 */
@DataJpaTest
public class AlunoTests {
	
	@Autowired
	private AlunoRepository repo;
	
	private Aluno aluno;
	
	@BeforeEach
	public void criaDados() {
		aluno = new Aluno("Marcos", "marcos@email.com", "12345", 20200001, "ENEM");
	}
	
	@Test
	public void testCreateAluno() {
		assertNotNull(repo.save(this.aluno));
	}
	
	@Test
	public void testUpdateAluno() {
		Aluno alunoNovo = repo.save(this.aluno);
		
		String novoNome = "Marcos Alterado";
		
		alunoNovo.setNome(novoNome);
		
		repo.save(alunoNovo);
		
		assertEquals(novoNome, repo.findAll().get(0).getNome());
	}

	@Test
	public void testDeleteAluno() {
		repo.delete(repo.save(this.aluno));
		
		assertThat(repo.findAll()).isEmpty();
	}

	@Test
	public void testSelectAluno() {
		repo.save(this.aluno);
		
		assertThat(repo.findAll()).isNotEmpty();
	}

}
