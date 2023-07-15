package br.com.banco.controller.transferencia.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.conta.dto.TransferenciaContaGetDto;
import br.com.banco.model.transferencia.Transferencia;
import br.com.banco.service.transferencia.TransferenciaService;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaControllerGet {

	@Autowired
	private TransferenciaService transferenciaService;

	@GetMapping
	public ResponseEntity<List<TransferenciaContaGetDto>> listarTodos() {
		return ResponseEntity.ok(transferenciaService.findAll());
	}
	
	@GetMapping("/teste")
	public ResponseEntity<List<Transferencia>> teste() {
		return ResponseEntity.ok(transferenciaService.findAllTeste());
	}
}
