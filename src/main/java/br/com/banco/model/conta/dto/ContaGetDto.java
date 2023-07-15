package br.com.banco.model.conta.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.conta.Conta;
import br.com.banco.model.transferencia.Transferencia;

public class ContaGetDto {
	private Long id;
	private String nomeResponsavel;
	private List<TransferenciaContaGetDto> transferencias;

	public ContaGetDto(Conta conta) {
		this.id = conta.getId();
		this.nomeResponsavel = conta.getNomeResponsavel();
		List<Transferencia> transf = new ArrayList<>(conta.getTransferencias());
		List<TransferenciaContaGetDto> transfDTO = new ArrayList<>();
		for (Transferencia transferencia : transf) {
			transfDTO.add(new TransferenciaContaGetDto(transferencia));
		}
		this.transferencias = transfDTO;
	}

	public List<TransferenciaContaGetDto> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<TransferenciaContaGetDto> transferencias) {
		this.transferencias = transferencias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

}
