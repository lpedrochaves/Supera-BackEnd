package br.com.banco.model.transferencia;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.banco.model.conta.Conta;

@Entity
@Table(name = "transferencia")
public class Transferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_transferencia", unique = true)
	private Long id;
	@Column(name = "data_transferencia", nullable = false)
	private LocalDateTime dataTransferencia;
	// precision = 20, scale = 2,
	@Column(name = "valor", precision = 20, scale = 2, columnDefinition = "numeric(10,2)")
	// @Type(type = "big_decimal")
	private Double valor;
	@Column(name = "tipo", nullable = false, length = 15)
	private String tipo;
	@Column(name = "nome_operador_transacao", length = 50)
	private String nomeOperadorTransacao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conta")
	private Conta conta;

	public Transferencia() {

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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
