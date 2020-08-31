package br.com.marcos.matriculascore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.marcos.matriculascore.dominio.Disciplina;
import br.com.marcos.matriculascore.dominio.Professor;
import br.com.marcos.matriculascore.repository.DisciplinaRepository;
import br.com.marcos.matriculascore.repository.ProfessorRepository;

/**
 * Classe para realizar testes de CRUD em Disciplina
 * @author Marcos Macedo
 *
 */
@DataJpaTest
public class DisciplinaTests {
	
	@Autowired
	private DisciplinaRepository repo;
	
	@Autowired
	private ProfessorRepository repoProfessor;
	
	private Disciplina disciplina;
	
	@BeforeEach
	public void criaDados() {
		Professor professor = repoProfessor.save(new Professor("João", "professor@email.com", "54321", "Doutor"));
		disciplina = new Disciplina("Disciplina 1", "D1", 360, professor);
	}
	
	@Test
	public void testCreateDisciplina() {
		assertNotNull(repo.save(this.disciplina));
	}
	
	@Test
	public void testUpdateDisciplina() {
		Disciplina disciplinaNova = repo.save(this.disciplina);
		
		String novaDescricao = "Disciplina 1 Alterada";
		
		disciplinaNova.setDescricao(novaDescricao);
		
		repo.save(disciplinaNova);
		
		assertEquals(novaDescricao, repo.findAll().get(0).getDescricao());
	}

	@Test
	public void testDeleteDisciplina() {
		repo.delete(repo.save(this.disciplina));
		
		assertThat(repo.findAll()).isEmpty();
	}

	@Test
	public void testSelectDisciplina() {
		repo.save(this.disciplina);
		
		assertThat(repo.findAll()).isNotEmpty();
	}

}
