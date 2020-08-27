package br.com.marcos.matriculascore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.matriculascore.dominio.Turma;

/**
 * Interface que estende JpaRepository, sendo possível utilizar as operações CRUD para Turma 
 * @author Marcos Macedo
 *
 */
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
