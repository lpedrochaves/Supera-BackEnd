package br.com.banco.repository.transferencia;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.banco.model.transferencia.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	@Query(value = "SELECT * FROM transferencia WHERE nome_operador_transacao LIKE %:nomeOperadorTransacao%", nativeQuery = true)
	Page<Transferencia> findByNomeOperadorTransacaoPaginada(@Param("nomeOperadorTransacao") String nome,
			Pageable pageable);
	@Query(value = "SELECT * FROM transferencia", nativeQuery = true)
	Page<Transferencia> buscarTodos(Pageable pageable);
	
	@Query(value = "SELECT * FROM transferencia t WHERE data_transferencia BETWEEN TO_DATE(:dataInicio,'YYYYMMDD')  AND TO_DATE(:dataFim,'YYYYMMDD')  AND nome_operador_transacao = :nome", nativeQuery = true)
	Page<Transferencia> buscarTransferenciaPaginada(@Param("dataInicio") String dataInicio,
			@Param("dataFim") String dataFim, @Param("nome") String nome, Pageable pageable);

	@Query(value = "SELECT * FROM transferencia t WHERE data_transferencia BETWEEN TO_DATE(:dataInicio,'YYYYMMDD')  AND TO_DATE(:dataFim,'YYYYMMDD')", nativeQuery = true)
	Page<Transferencia> buscarTransferenciaPorPeriodoPaginada(@Param("dataInicio") String dataInicio,
			@Param("dataFim") String dataFim, Pageable pageable);
}
