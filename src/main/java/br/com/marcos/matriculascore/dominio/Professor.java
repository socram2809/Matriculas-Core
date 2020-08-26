package br.com.marcos.matriculascore.dominio;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe de domínio que representa um professor
 * @author Marcos Macedo
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Professor extends Pessoa {
	
	/**
	 * Titulação (mestre, doutor, PHD) do professor
	 */
	private String titulacao;
}
