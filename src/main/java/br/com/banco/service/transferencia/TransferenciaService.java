package br.com.banco.service.transferencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.transferencia.Transferencia;
import br.com.banco.model.transferencia.dto.TransferenciaGetDto;
import br.com.banco.repository.transferencia.TransferenciaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	public Page<TransferenciaGetDto> buscarPorNomePaginada(String nome, Pageable pageable) throws Exception {
		Double valorTotal = 0.0;
		Double valorNoPeriodo = 0.0;
		List<Transferencia> transferenciaFindAll = transferenciaRepository.findAll();
		for (Transferencia t : transferenciaFindAll) {
			valorTotal += t.getValor();
		}
		Page<Transferencia> transferenciaPage = transferenciaRepository.findByNomeOperadorTransacaoPaginada(nome,
				pageable);
		if (transferenciaPage.isEmpty()) {
			throw new Exception("Transferência não encontrada");
		}
		List<TransferenciaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transf : transferenciaPage.getContent()) {
			valorNoPeriodo += transf.getValor();
			transDtos.add(new TransferenciaGetDto(transf, valorTotal, valorNoPeriodo));
		}
		return new PageImpl<>(transDtos, pageable, transferenciaPage.getTotalElements());
	}

	public Page<TransferenciaGetDto> buscarComTodosCamposPaginada(String dataInicio, String dataFim, String nome,
			Pageable pageable) throws Exception {
		Double valorTotal = 0.0;
		Double valorNoPeriodo = 0.0;
		List<Transferencia> transferenciaFindAll = transferenciaRepository.findAll();
		for (Transferencia t : transferenciaFindAll) {
			valorTotal += t.getValor();
		}
		Page<Transferencia> transferenciaPage = transferenciaRepository.buscarTransferenciaPaginada(dataInicio, dataFim,
				nome, pageable);
		if (transferenciaPage.isEmpty()) {
			throw new Exception("Transferência não encontrada");
		}

		List<TransferenciaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transf : transferenciaPage.getContent()) {
			valorNoPeriodo += transf.getValor();
			transDtos.add(new TransferenciaGetDto(transf, valorTotal, valorNoPeriodo));
		}
		return new PageImpl<>(transDtos, pageable, transferenciaPage.getTotalElements());
	}

	public Page<TransferenciaGetDto> buscarComPeriodoPaginada(String dataInicio, String dataFim, Pageable pageable)
			throws Exception {
		Double valorTotal = 0.0;
		Double valorNoPeriodo = 0.0;
		List<Transferencia> transferenciaFindAll = transferenciaRepository.findAll();
		for (Transferencia t : transferenciaFindAll) {
			valorTotal += t.getValor();
		}
		Page<Transferencia> transferenciaPage = transferenciaRepository
				.buscarTransferenciaPorPeriodoPaginada(dataInicio, dataFim, pageable);
		if (transferenciaPage.isEmpty()) {
			throw new Exception("Transferência não encontrada");
		}
		List<TransferenciaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transf : transferenciaPage.getContent()) {

			valorNoPeriodo += transf.getValor();
			transDtos.add(new TransferenciaGetDto(transf, valorTotal, valorNoPeriodo));
		}
		return new PageImpl<>(transDtos, pageable, transferenciaPage.getTotalElements());
	}

	public Page<TransferenciaGetDto> findAllPaginada(Pageable pageable) {
		Double valorTotal = 0.0;
		Double valorNoPeriodo = 0.0;
		List<Transferencia> transferenciaFindAll = transferenciaRepository.findAll();
		for (Transferencia t : transferenciaFindAll) {
			valorTotal += t.getValor();
		}
		Page<Transferencia> transferenciaPage = transferenciaRepository.buscarTodos(pageable);
		List<TransferenciaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transferencia : transferenciaPage.getContent()) {
			valorNoPeriodo += transferencia.getValor();
			transDtos.add(new TransferenciaGetDto(transferencia, valorTotal, valorNoPeriodo));
		}

		return new PageImpl<>(transDtos, pageable, transferenciaPage.getTotalElements());
	}

	// Sem Paginação
	public List<TransferenciaGetDto> findAll() {
		Double valorTotal = 0.0;
		Double valorNoPeriodo = 0.0;
		List<Transferencia> transferenciaFindAll = transferenciaRepository.findAll();
		for (Transferencia t : transferenciaFindAll) {
			valorTotal += t.getValor();
		}

		List<TransferenciaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transferencia : transferenciaFindAll) {
			valorNoPeriodo += transferencia.getValor();
			transDtos.add(new TransferenciaGetDto(transferencia, valorTotal, valorNoPeriodo));
		}

		return transDtos;
	}

}
