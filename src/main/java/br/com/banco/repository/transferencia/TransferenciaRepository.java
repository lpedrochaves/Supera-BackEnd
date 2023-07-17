package br.com.banco.repository.transferencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.banco.model.transferencia.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	@Query(value = "SELECT * FROM transferencia WHERE nome_operador_transacao LIKE %:nomeOperadorTransacao%", nativeQuery = true)
	List<Transferencia> findByNomeOperadorTransacao(@Param("nomeOperadorTransacao") String nome);

	@Query(value = "SELECT * FROM transferencia t WHERE data_transferencia BETWEEN TO_DATE(:dataInicio,'YYYYMMDD')  AND TO_DATE(:dataFim,'YYYYMMDD')  AND nome_operador_transacao = :nome", nativeQuery = true)
	List<Transferencia> buscarTransferencia(@Param("dataInicio") String dataInicio, @Param("dataFim") String dataFim,
			@Param("nome") String nome);
}
