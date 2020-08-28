package br.com.marcos.matriculascore.resource;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculascore.dto.AtualizarProfessorDTO;
import br.com.marcos.matriculascore.dto.CriarProfessorDTO;
import br.com.marcos.matriculascore.dto.ProfessorResponseDTO;
import br.com.marcos.matriculascore.repository.ProfessorRepository;

/**
 * Controlador REST que mapeia a URI "/professor" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	/**
	 * Injeção de dependência para utilizar o repositório de Professor
	 */
	@Autowired
	private ProfessorRepository professorRepository;
	
	/**
	 * Injeção de dependência para enviar mensagem da criação/alteração/remoção do professor
	 */
	@Autowired
	private JmsTemplate jmsTemplateTopic;
	
	/**
	 * Processa requisições que utilizam o método POST do HTTP para inserir um professor
	 * @param professor
	 * @return
	 */
	@Transactional
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProfessorResponseDTO inserirProfessor(@Valid @RequestBody CriarProfessorDTO professor) {
		ProfessorResponseDTO professorDTO = ProfessorResponseDTO.transformaEmDTO(professorRepository.save(professor.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("professor.update", new AtualizarProfessorDTO(professorDTO));
		return professorDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método PUT do HTTP para atualizar um professor
	 * @param professor
	 * @return
	 */
	@Transactional
	@PutMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public ProfessorResponseDTO atualizarProfessor(@Valid @RequestBody AtualizarProfessorDTO professor) {
		ProfessorResponseDTO professorDTO = ProfessorResponseDTO.transformaEmDTO(professorRepository.save(professor.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("professor.update", new AtualizarProfessorDTO(professorDTO));
		return professorDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método DELETE do HTTP para remover um professor
	 * @param id
	 */
	@Transactional
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
		jmsTemplateTopic.convertAndSend("professor.delete", id);
	}
}
