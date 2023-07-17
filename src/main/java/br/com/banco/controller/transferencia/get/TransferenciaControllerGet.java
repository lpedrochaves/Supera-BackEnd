package br.com.banco.controller.transferencia.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.conta.dto.TransferenciaContaGetDto;
import br.com.banco.model.transferencia.dto.TransferenciaGetDto;
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

	@GetMapping("/buscar-por-nome/nome")
	public ResponseEntity<Object> search(@RequestParam String nome) throws Exception {
		if (nome == null) {
			return ResponseEntity.ok(transferenciaService.findAll());
		}
		return ResponseEntity.ok(transferenciaService.buscarPorNome(nome));
	}

	@GetMapping("/data-inicio/{dataInicial}")
	public ResponseEntity<List<TransferenciaGetDto>> buscarPorData(@PathVariable String dataInicial) throws Exception {
		return ResponseEntity.ok(transferenciaService.buscarPorDataInicial(dataInicial));
	}

	@GetMapping("/data-fim/{dataFinal}")
	public ResponseEntity<List<TransferenciaGetDto>> buscarPorDataFinal(@PathVariable String dataFinal)
			throws Exception {
		return ResponseEntity.ok(transferenciaService.buscarPorDataFinal(dataFinal));
	}
	@GetMapping("/busca-total")
	public ResponseEntity<List<TransferenciaGetDto>> buscarTotal(@RequestParam String dataInicial,
			@RequestParam String dataFinal, @RequestParam String nome)  {
		return ResponseEntity.ok(transferenciaService.buscarComTodosCampos(dataInicial, dataFinal, nome));
	}

}
