package br.com.marcos.matriculascore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.matriculascore.dominio.Disciplina;

/**
 * Interface que estende JpaRepository, sendo possível utilizar as operações CRUD para Disciplina 
 * @author Marcos Macedo
 *
 */
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
