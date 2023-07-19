package br.com.banco.controller.conta.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.conta.dto.ContaGetDto;
import br.com.banco.service.conta.ContaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/conta")
public class ContaControllerGet {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	@ApiOperation(value = "Retorna uma Lista de Contas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista de Contas"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Exceção interna da aplicação") })
	public ResponseEntity<List<ContaGetDto>> listarTodos() {
		return ResponseEntity.ok(contaService.findAll());
	}

}
