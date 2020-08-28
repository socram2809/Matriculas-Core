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

import br.com.marcos.matriculascore.dto.AtualizarTurmaDTO;
import br.com.marcos.matriculascore.dto.CriarTurmaDTO;
import br.com.marcos.matriculascore.dto.TurmaResponseDTO;
import br.com.marcos.matriculascore.repository.TurmaRepository;

/**
 * Controlador REST que mapeia a URI "/turma" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/turma")
public class TurmaResource {

	/**
	 * Injeção de dependência para utilizar o repositório de Turma
	 */
	@Autowired
	private TurmaRepository turmaRepository;
	
	/**
	 * Injeção de dependência para enviar mensagem da criação/alteração/remoção da turma
	 */
	@Autowired
	private JmsTemplate jmsTemplateTopic;
	
	/**
	 * Processa requisições que utilizam o método POST do HTTP para inserir uma turma
	 * @param turma
	 * @return
	 */
	@Transactional
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TurmaResponseDTO inserirTurma(@Valid @RequestBody CriarTurmaDTO turma) {
		TurmaResponseDTO turmaDTO = TurmaResponseDTO.transformaEmDTO(turmaRepository.save(turma.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("turma.create", turmaDTO);
		return turmaDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método PUT do HTTP para atualizar uma turma
	 * @param turma
	 * @return
	 */
	@Transactional
	@PutMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public TurmaResponseDTO atualizarTurma(@Valid @RequestBody AtualizarTurmaDTO turma) {
		TurmaResponseDTO turmaDTO = TurmaResponseDTO.transformaEmDTO(turmaRepository.save(turma.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("turma.update", turmaDTO);
		return turmaDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método DELETE do HTTP para remover uma turma
	 * @param id
	 */
	@Transactional
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerTurma(@PathVariable Long id) {
		turmaRepository.deleteById(id);
		jmsTemplateTopic.convertAndSend("turma.delete", id);
	}
}
