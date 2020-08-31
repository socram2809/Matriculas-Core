package br.com.marcos.matriculascore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.marcos.matriculascore.dominio.Professor;
import br.com.marcos.matriculascore.repository.ProfessorRepository;

/**
 * Classe para realizar testes de CRUD em Professor
 * @author Marcos Macedo
 *
 */
@DataJpaTest
public class ProfessorTests {
	
	@Autowired
	private ProfessorRepository repo;
	
	private Professor professor;
	
	@BeforeEach
	public void criaDados() {
		professor = new Professor("João", "joao@email.com", "54321", "Doutor");
	}
	
	@Test
	public void testCreateProfessor() {
		assertNotNull(repo.save(this.professor));
	}
	
	@Test
	public void testUpdateProfessor() {
		Professor professorNovo = repo.save(this.professor);
		
		String novoNome = "João Alterado";
		
		professorNovo.setNome(novoNome);
		
		repo.save(professorNovo);
		
		assertEquals(novoNome, repo.findAll().get(0).getNome());
	}

	@Test
	public void testDeleteProfessor() {
		repo.delete(repo.save(this.professor));
		
		assertThat(repo.findAll()).isEmpty();
	}

	@Test
	public void testSelectProfessor() {
		repo.save(this.professor);
		
		assertThat(repo.findAll()).isNotEmpty();
	}

}
