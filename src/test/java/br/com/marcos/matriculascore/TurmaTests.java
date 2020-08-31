package br.com.marcos.matriculascore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.marcos.matriculascore.dominio.Aluno;
import br.com.marcos.matriculascore.dominio.Disciplina;
import br.com.marcos.matriculascore.dominio.Professor;
import br.com.marcos.matriculascore.dominio.Turma;
import br.com.marcos.matriculascore.repository.AlunoRepository;
import br.com.marcos.matriculascore.repository.DisciplinaRepository;
import br.com.marcos.matriculascore.repository.ProfessorRepository;
import br.com.marcos.matriculascore.repository.TurmaRepository;

/**
 * Classe para realizar testes de CRUD em Turma
 * @author Marcos Macedo
 *
 */
@DataJpaTest
public class TurmaTests {
	
	@Autowired
	private TurmaRepository repo;
	
	@Autowired
	private ProfessorRepository repoProfessor;
	
	@Autowired
	private AlunoRepository repoAluno;
	
	@Autowired
	private DisciplinaRepository repoDisciplina;
	
	private Turma turma;
	
	@BeforeEach
	public void criaDados() {
		Aluno aluno = new Aluno("Marcos", "marcos@email.com", "12345", 20200001, "ENEM");
		repoAluno.save(aluno);
		Professor professor = new Professor("João", "joao@email.com", "54321", "Doutor");
		repoProfessor.save(professor);
		Disciplina disciplina = new Disciplina("Disciplina 1", "D1", 360, professor);
		repoDisciplina.save(disciplina);
		turma = new Turma("Turma 1", 2020, 1, 20, new ArrayList<>(Arrays.asList(disciplina)), new ArrayList<>(Arrays.asList(aluno)));
	}
	
	@Test
	public void testCreateTurma() {
		assertNotNull(repo.save(this.turma));
	}
	
	@Test
	public void testUpdateTurma() {
		Turma turmaNova = repo.save(this.turma);
		
		String novoNome = "Turma 1 Alterada";
		
		turmaNova.setDescricao(novoNome);
		
		repo.save(turmaNova);
		
		assertEquals(novoNome, repo.findAll().get(0).getDescricao());
	}

	@Test
	public void testDeleteTurma() {
		repo.delete(repo.save(this.turma));
		
		assertThat(repo.findAll()).isEmpty();
	}

	@Test
	public void testSelectTurma() {
		repo.save(this.turma);
		
		assertThat(repo.findAll()).isNotEmpty();
	}

}
