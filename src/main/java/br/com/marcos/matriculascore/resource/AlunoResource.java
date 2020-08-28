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

import br.com.marcos.matriculascore.dto.AlunoResponseDTO;
import br.com.marcos.matriculascore.dto.AtualizarAlunoDTO;
import br.com.marcos.matriculascore.dto.CriarAlunoDTO;
import br.com.marcos.matriculascore.repository.AlunoRepository;

/**
 * Controlador REST que mapeia a URI "/aluno" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/aluno")
public class AlunoResource {
	
	/**
	 * Injeção de dependência para utilizar o repositório de Aluno
	 */
	@Autowired
	private AlunoRepository alunoRepository;
	
	/**
	 * Injeção de dependência para enviar mensagem da criação/alteração/remoção do aluno
	 */
	@Autowired
	private JmsTemplate jmsTemplateTopic;
	
	/**
	 * Processa requisições que utilizam o método POST do HTTP para inserir um aluno
	 * @param aluno
	 * @return
	 */
	@Transactional
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AlunoResponseDTO inserirAluno(@Valid @RequestBody CriarAlunoDTO aluno) {
		AlunoResponseDTO alunoDTO = AlunoResponseDTO.transformaEmDTO(alunoRepository.save(aluno.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("aluno.update", alunoDTO);
		return alunoDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método PUT do HTTP para atualizar um aluno
	 * @param aluno
	 * @return
	 */
	@Transactional
	@PutMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public AlunoResponseDTO atualizarAluno(@Valid @RequestBody AtualizarAlunoDTO aluno) {
		AlunoResponseDTO alunoDTO = AlunoResponseDTO.transformaEmDTO(alunoRepository.save(aluno.transformaParaObjeto()));
		jmsTemplateTopic.convertAndSend("aluno.update", alunoDTO);
		return alunoDTO;
	}
	
	/**
	 * Processa requisições que utilizam o método DELETE do HTTP para remover um aluno
	 * @param id
	 */
	@Transactional
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerAluno(@PathVariable Long id) {
		alunoRepository.deleteById(id);
		jmsTemplateTopic.convertAndSend("aluno.delete", id);
	}
}
