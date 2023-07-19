package br.com.banco.controller.transferencia.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.banco.model.transferencia.dto.TransferenciaGetDto;
import br.com.banco.service.transferencia.TransferenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaControllerGet {

	@Autowired
	private TransferenciaService transferenciaService;

	@GetMapping
	@ApiOperation(value = "Retorna uma Lista de Transferências sem Paginação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista de Transferências"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Exceção interna da aplicação") })
	public ResponseEntity<List<TransferenciaGetDto>> listarTodos() {
		return ResponseEntity.ok(transferenciaService.findAll());
	}

	@GetMapping("/paginada")
	@ApiOperation(value = "Retorna uma Lista de Transferências com Paginação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista de Transferências Paginada"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Exceção interna da aplicação") })
	public ResponseEntity<Page<TransferenciaGetDto>> listarTodosPaginada(Pageable pageable) {
		return ResponseEntity.ok(transferenciaService.findAllPaginada(pageable));
	}

	@GetMapping("/buscar-por-nome-paginada")
	@ApiOperation(value = "Retorna uma Lista de Transferências com Paginação, Referente ao nome escolhido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista de Transferências Paginada,com Base no Nome Informado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Exceção interna da aplicação") })
	public ResponseEntity<Object> busPorNomePaginada(@RequestParam String nome, Pageable pageable) throws Exception {
		if (nome == null) {
			return ResponseEntity.ok(transferenciaService.findAll());
		}
		return ResponseEntity.ok(transferenciaService.buscarPorNomePaginada(nome, pageable));
	}

	@GetMapping("/busca-total-paginada")
	@ApiOperation(value = "Retorna uma Lista de Transferências com Paginação, Referente ao nome escolhido, e ao Período Selecionado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista de Transferências Paginada,com Base no Nome, Datas, Informadas"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Exceção interna da aplicação") })
	public ResponseEntity<Page<TransferenciaGetDto>> buscarTotalPaginada(@RequestParam String dataInicial,
			@RequestParam String dataFinal, @RequestParam String nome, Pageable pageable) throws Exception {
		return ResponseEntity
				.ok(transferenciaService.buscarComTodosCamposPaginada(dataInicial, dataFinal, nome, pageable));
	}

	@GetMapping("/busca-por-periodo-paginada")
	@ApiOperation(value = "Retorna uma Lista de Transferências com Paginação, Referente ao Período Selecionado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista de Transferências Paginada,com nas Datas Informadas"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Exceção interna da aplicação") })
	public ResponseEntity<Page<TransferenciaGetDto>> buscarPorPeriodoPaginada(@RequestParam String dataInicial,
			@RequestParam String dataFinal, Pageable pageable) throws Exception {
		return ResponseEntity.ok(transferenciaService.buscarComPeriodoPaginada(dataInicial, dataFinal, pageable));
	}

}
