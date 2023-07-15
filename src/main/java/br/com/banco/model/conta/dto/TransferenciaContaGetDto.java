package br.com.banco.model.conta.dto;

import java.time.LocalDateTime;

import br.com.banco.model.transferencia.Transferencia;

public class TransferenciaContaGetDto {
	private Long id;
	private LocalDateTime dataTransferencia;
	private Double valor;
	private String tipo;
	private String nomeOperadorTransacao;

	public TransferenciaContaGetDto(Transferencia transferencia) {
		this.id = transferencia.getId();
		this.dataTransferencia = transferencia.getDataTransferencia();
		this.valor = transferencia.getValor();
		this.tipo = transferencia.getTipo();
		this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

}
