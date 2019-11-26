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
						"angie", "1234");
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

			stmt = conn
					.prepareStatement(
							"INSERT INTO PEDIDOS (CLIENTE, ENDERECO, ESTADO, QTD_ROBO_DOMESTICO, QTD_REATOR_SOLAR, QTD_REATOR_ARK, TOTAL) VALUES (?, ?, ?, ?, ?, ?, ?)", //
							Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, pedido.getCliente());
			stmt.setString(2, pedido.getEndereco());
			stmt.setString(3, pedido.getEstado());
			stmt.setInt(4, pedido.getQtdRoboDomestico());
			stmt.setInt(5, pedido.getQtdReatorSolar());
			stmt.setInt(6, pedido.getQtdReatorArk());
			stmt.setDouble(7, pedido.getTotal());

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
