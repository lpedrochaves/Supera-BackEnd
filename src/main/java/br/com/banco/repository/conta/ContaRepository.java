package br.com.banco.repository.conta;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.conta.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
