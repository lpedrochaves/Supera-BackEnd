package br.com.banco.service.conta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.conta.Conta;
import br.com.banco.model.conta.dto.ContaGetDto;
import br.com.banco.repository.conta.ContaRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;

	public List<ContaGetDto> findAll() {
		List<Conta> contas = contaRepository.findAll();
		List<ContaGetDto> contasDTO = new ArrayList<>();
		for (Conta conta : contas) {
			contasDTO.add(new ContaGetDto(conta));
		}
		return contasDTO;
	}
}
