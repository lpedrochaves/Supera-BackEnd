package br.com.banco.controller.conta.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.conta.dto.ContaGetDto;
import br.com.banco.service.conta.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaControllerGet {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public ResponseEntity<List<ContaGetDto>> listarTodos() {
		return ResponseEntity.ok(contaService.findAll());
	}

}
