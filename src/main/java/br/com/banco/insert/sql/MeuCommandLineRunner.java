package br.com.banco.insert.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MeuCommandLineRunner implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MeuCommandLineRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insira aqui o código para executar os comandos SQL diretamente
        String sql1 = "INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano')";       
        String sql2 = " INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano')";
        
        String sql3 = " INSERT INTO transferencia (id_transferencia ,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1)";
        String sql4 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2)";
        String sql5 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1)";
        String sql6 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2)";
        String sql7 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1)";
        String sql8 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (6,'2021-04-01 12:12:04+03',2573.09,'TRANSFERENCIA', 'Carlos',2)";
        
        String sql9 = " INSERT INTO transferencia (id_transferencia ,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (7,'2019-01-01 12:00:00+03',3895.46,'DEPOSITO', null, 1)";
        String sql10 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (8,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2)";
        String sql11 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (9,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1)";
        String sql12 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (10,'2019-08-07 08:12:45+03',-5530.50,'SAQUE', null,2)";
        String sql13 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (11,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Jorge',1)";
        String sql14 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (12,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Marcia',2)";
        
        String sql15 = " INSERT INTO transferencia (id_transferencia ,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (13,'2019-01-01 12:00:00+03',3085.46,'DEPOSITO', null, 1)";
        String sql16 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (14,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2)";
        String sql17 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (15,'2019-05-04 08:12:45+03',-50.50,'SAQUE', null,1)";
        String sql18 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (16,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2)";
        String sql19 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (17,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1)";
        String sql20 = " INSERT INTO transferencia (id_transferencia,data_transferencia, valor, tipo, nome_operador_transacao, id_conta) VALUES (18,'2021-04-01 12:12:04+03',2573.09,'TRANSFERENCIA', 'Ronnyscley',2)";


        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
        
        jdbcTemplate.execute(sql3);
        jdbcTemplate.execute(sql4);
        jdbcTemplate.execute(sql5);
        jdbcTemplate.execute(sql6);
        jdbcTemplate.execute(sql7);
        jdbcTemplate.execute(sql8);
        jdbcTemplate.execute(sql9);
        jdbcTemplate.execute(sql10);
        jdbcTemplate.execute(sql11);
        jdbcTemplate.execute(sql12);
        jdbcTemplate.execute(sql13);
        jdbcTemplate.execute(sql14);
        jdbcTemplate.execute(sql15);
        jdbcTemplate.execute(sql16);
        jdbcTemplate.execute(sql17);
        jdbcTemplate.execute(sql18);
        jdbcTemplate.execute(sql19);
        jdbcTemplate.execute(sql20);
    }

}
