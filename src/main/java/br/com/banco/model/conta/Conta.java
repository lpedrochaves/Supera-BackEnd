package br.com.banco.model.conta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.banco.model.transferencia.Transferencia;

@Entity
@Table(name = "conta")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conta", unique = true)
	private Long id;
	@Column(name = "nome_responsavel", nullable = false, length = 50)
	private String nomeResponsavel;
	@OneToMany(mappedBy = "conta")
	@Column(name = "transferencia")
	private List<Transferencia> transferencias;

	public Conta() {

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

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}

}
