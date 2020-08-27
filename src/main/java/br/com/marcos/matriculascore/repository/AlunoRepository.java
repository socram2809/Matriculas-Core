package br.com.marcos.matriculascore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.matriculascore.dominio.Aluno;

/**
 * Interface que estende JpaRepository, sendo possível utilizar as operações CRUD para Aluno 
 * @author Marcos Macedo
 *
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
