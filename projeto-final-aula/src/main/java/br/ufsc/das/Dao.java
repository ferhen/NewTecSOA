package br.ufsc.das;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

	private Connection getConexao() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewTec", 
						"root", "");
				//System.out.println("Conexão realizada com Sucesso");
			} catch (SQLException e) {
				//System.out.println("Falha ao conectar ao banco de dados");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return conn;
		}
	public Pedido insert(Pedido pedido) {

		Connection conn = null;

		PreparedStatement stmt = null;

		try {
			conn = getConexao();

			/*
			stmt = conn.prepareStatement("INSERT INTO PEDIDOS (CLIENTE, EMAIL, ENDERECO, ESTADO, CODIGO_STARK_SYSTEMS, QTD_REATOR_SOLAR, QTD_REATOR_ARK, TOTAL_REATOR_SOLAR, TOTAL_REATOR_ARK, TOTAL_STARK_SYSTEM, CODIGO_BR_ROBOTICS, QTD_ROBO_DOMESTICO, QTD_ROBO_MEDICO, QTD_ROBO_SEGURANCA, TOTAL_ROBO_DOMESTICO, TOTAL_ROBO_MEDICO, TOTAL_ROBO_SEGURANCA, TOTAL_BR_ROBOTICS, FRETE, NUM_TRANSACAO_CARTAO, OPERADORA_CARTAO, TAXA_CARTAO, NUM_NOTA_FISCAL, TOTAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )", // 
                    Statement.RETURN_GENERATED_KEYS);
                    */
			
			stmt = conn.prepareStatement("INSERT INTO PEDIDOS (CLIENTE, EMAIL, ENDERECO, ESTADO,  QTD_REATOR_SOLAR, QTD_REATOR_ARK, QTD_ROBO_DOMESTICO, QTD_ROBO_MEDICO, QTD_ROBO_SEGURANCA, FRETE, NUM_NOTA_FISCAL, TOTAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )", // 
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, pedido.getCliente());
            stmt.setString(2, pedido.getEmail());
            stmt.setString(3, pedido.getEndereco());
            stmt.setString(4, pedido.getEstado());
            
            //stmt.setInt(5, .getCodigoStarkSystems());           
            stmt.setInt(5, pedido.getqtdReatorSolar());
            stmt.setInt(6, pedido.getqtdReatorArk());
            //stmt.setDouble(8, .getTotalReatorSolar());
            //stmt.setDouble(9, .getTotalReatorArk());
            //stmt.setDouble(10, .getTotalStarkSystem());
            
            //stmt.setInt(11, PedidoRobo.getCodigoBrRobotics());           
            stmt.setInt(7, pedido.getqtdRoboDomestico());
            stmt.setInt(8, pedido.getqtdRoboMedico());
            stmt.setInt(9, pedido.getqtdRoboSeguranca());
            //stmt.setDouble(15, .getTotalRoboDomestico());
            //stmt.setDouble(16, .getTotalRoboMedico());
            //stmt.setDouble(17, .getTotalRoboSeguranca());
            //stmt.setDouble(18, .getTotalBrRobotics());
			
			stmt.setDouble(10, pedido.getValorFrete()); 
			
			//stmt.setString(20, .getNumTransacaoCartao());
			//stmt.setString(21, .getOperadoraCartao());
			//stmt.setDouble(22, .getTaxaCartao());
			
			stmt.setString(11, pedido.getCdNotaFiscal());
			
			stmt.setDouble(12, pedido.getValorTotal());

			if (stmt.executeUpdate() == 1) {

				// Obtendo o id incremental...
				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {
						pedido.setCodigo(rs.getInt(1));
					}
				}

				return pedido;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

	}
}
