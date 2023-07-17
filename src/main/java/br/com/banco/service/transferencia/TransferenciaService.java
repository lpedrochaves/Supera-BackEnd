package br.com.banco.service.transferencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.conta.dto.TransferenciaContaGetDto;
import br.com.banco.model.transferencia.Transferencia;
import br.com.banco.model.transferencia.dto.TransferenciaGetDto;
import br.com.banco.repository.transferencia.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	public List<TransferenciaContaGetDto> findAll() {
		List<Transferencia> transferencias = transferenciaRepository.findAll();
		List<TransferenciaContaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transferencia : transferencias) {
			transDtos.add(new TransferenciaContaGetDto(transferencia));
		}

		return transDtos;
	}

	public List<TransferenciaGetDto> buscarPorNome(String nome) throws Exception {
		List<Transferencia> transferencia = transferenciaRepository.findByNomeOperadorTransacao(nome);
		List<TransferenciaGetDto> transDtos = new ArrayList<>();
		if (transferencia == null) {
			throw new Exception("Transferência não encontrada");
		}
		for (Transferencia transf : transferencia) {
			transDtos.add(new TransferenciaGetDto(transf));
		}
		return transDtos;
	}

	public List<TransferenciaGetDto> buscarPorDataInicial(String data) {
		List<Transferencia> transferencias = transferenciaRepository.findAll();
		List<TransferenciaGetDto> transDtos = new ArrayList<>();

		// CASO UTILIZE UMA STRING COMO PARAMETRO
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(data, formatter);

		for (Transferencia transferencia : transferencias) {
			if (date.isBefore(LocalDate.of(transferencia.getDataTransferencia().getYear(),
					transferencia.getDataTransferencia().getMonth(),
					transferencia.getDataTransferencia().getDayOfMonth()))) {
				transDtos.add(new TransferenciaGetDto(transferencia));
			}
		}
		return transDtos;
	}

	public List<TransferenciaGetDto> buscarPorDataFinal(String data) {
		List<Transferencia> transferencias = transferenciaRepository.findAll();
		List<TransferenciaGetDto> transDtos = new ArrayList<>();

		// CASO UTILIZE UMA STRING COMO PARAMETRO
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(data, formatter);

		for (Transferencia transferencia : transferencias) {
			if (date.isAfter(LocalDate.of(transferencia.getDataTransferencia().getYear(),
					transferencia.getDataTransferencia().getMonth(),
					transferencia.getDataTransferencia().getDayOfMonth()))) {
				transDtos.add(new TransferenciaGetDto(transferencia));
			}
		}
		return transDtos;
	}

	public List<TransferenciaGetDto> buscarComTodosCampos(String dataInicio, String dataFim, String nome){
		List<Transferencia> transferencia = transferenciaRepository.buscarTransferencia(dataInicio, dataFim, nome);
		List<TransferenciaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transf : transferencia) {
			transDtos.add(new TransferenciaGetDto(transf));
		}
		return transDtos;
	}

}
