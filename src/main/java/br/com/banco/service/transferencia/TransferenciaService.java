package br.com.banco.service.transferencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.conta.dto.TransferenciaContaGetDto;
import br.com.banco.model.transferencia.Transferencia;
import br.com.banco.repository.transferencia.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	public List<TransferenciaContaGetDto> findAll(){
		List<Transferencia> transferencias = transferenciaRepository.findAll();
		List<TransferenciaContaGetDto> transDtos = new ArrayList<>();
		for (Transferencia transferencia : transferencias) {
			transDtos.add(new TransferenciaContaGetDto(transferencia));
		}
		
		return transDtos;
	}

	public List<Transferencia> findAllTeste() {
		// TODO Auto-generated method stub
		return transferenciaRepository.findAll();
	}
}
