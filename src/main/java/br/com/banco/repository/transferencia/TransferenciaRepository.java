package br.com.banco.repository.transferencia;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.transferencia.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

}
