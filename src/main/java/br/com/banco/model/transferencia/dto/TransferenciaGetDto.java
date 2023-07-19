package br.com.banco.model.transferencia.dto;

import java.time.LocalDate;

import br.com.banco.model.transferencia.Transferencia;

public class TransferenciaGetDto {
	private Long id;
	private LocalDate dataTransferencia;
	private Double valor;
	private String tipo;
	private String nomeOperadorTransacao;
	private Double valorTotal;
	private Double valorNoPeriodo;

	public TransferenciaGetDto(Transferencia transferencia) {
		this.id = transferencia.getId();
		this.dataTransferencia = LocalDate.of(transferencia.getDataTransferencia().getYear(),
				transferencia.getDataTransferencia().getMonth(), transferencia.getDataTransferencia().getDayOfMonth());
		this.valor = transferencia.getValor();
		this.tipo = transferencia.getTipo();
		this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();

	}

	public TransferenciaGetDto(Transferencia transferencia, Double valorTotal, Double valorNoPeriodo) {
		this.id = transferencia.getId();
		this.dataTransferencia = LocalDate.of(transferencia.getDataTransferencia().getYear(),
				transferencia.getDataTransferencia().getMonth(), transferencia.getDataTransferencia().getDayOfMonth());
		this.valor = transferencia.getValor();
		this.tipo = transferencia.getTipo();
		this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
		this.valorTotal = valorTotal;
		this.valorNoPeriodo = valorNoPeriodo;
	}


	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorNoPeriodo() {
		return valorNoPeriodo;
	}

	public void setValorNoPeriodo(Double valorNoPeriodo) {
		this.valorNoPeriodo = valorNoPeriodo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
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
