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

import br.com.marcos.matriculascore.dto.AtualizarDisciplinaDTO;
import br.com.marcos.matriculascore.dto.CriarDisciplinaDTO;
import br.com.marcos.matriculascore.dto.DisciplinaResponseDTO;
import br.com.marcos.matriculascore.repository.DisciplinaRepository;

/**
 * Controlador REST que mapeia a URI "/disciplina" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	/**
	 * Injeção de dependência para utilizar o repositório de Disciplina
	 */
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	/**
	 * Injeção de dependência para enviar mensagem da criação/alteração/remoção da disciplina
	 */
	@Autowired
	private JmsTemplate jmsTemplateTopic;
	
	/**
	 * Processa requisições que utilizam o método POST do HTTP para inserir uma disciplina
	 * @param disciplina
	 * @return
	 */
	@Transactional
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DisciplinaResponseDTO inserirDisciplina(@Valid @RequestBody CriarDisciplinaDTO disciplina) {
		DisciplinaResponseDTO disciplinaDTO = DisciplinaResponseDTO.transformaEmDTO(disciplinaRepository.save(disciplina.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("disciplina.create", disciplinaDTO);
		return disciplinaDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método PUT do HTTP para atualizar uma disciplina
	 * @param disciplina
	 * @return
	 */
	@Transactional
	@PutMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public DisciplinaResponseDTO atualizarDisciplina(@Valid @RequestBody AtualizarDisciplinaDTO disciplina) {
		DisciplinaResponseDTO disciplinaDTO = DisciplinaResponseDTO.transformaEmDTO(disciplinaRepository.save(disciplina.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("disciplina.update", disciplinaDTO);
		return disciplinaDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método DELETE do HTTP para remover uma disciplina
	 * @param id
	 */
	@Transactional
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerDisciplina(@PathVariable Long id) {
		disciplinaRepository.deleteById(id);
		jmsTemplateTopic.convertAndSend("disciplina.delete", id);
	}
}
