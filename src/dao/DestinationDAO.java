package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Destination;

public class DestinationDAO {
	private Connection conn = null;
	PreparedStatement pstm = null;

	public DestinationDAO() {

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void createDestination(Destination destino) {
		String strSQL = "INSERT INTO destination (nome, categoria, condicao, preco, quantidade) VALUES (?,?,?,?,?)";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getCategoria());
			pstm.setString(3, destino.getCondicao());
			pstm.setFloat(4, destino.getPreco());
			pstm.setInt(5, destino.getQuantidade());
			pstm.executeUpdate();

			System.out.println("\n*** Destino cadastrado com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Destination> readDestination() {
		String strSQL = "SELECT * FROM destination";
		
		List<Destination> Destino = new ArrayList<Destination>();

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				Destination destino = new Destination();
				destino.setId_destino(result.getInt("id_destino"));
				destino.setNome(result.getString("nome"));
				destino.setCategoria(result.getString("categoria"));
				destino.setCondicao(result.getString("condicao"));
				destino.setPreco(result.getFloat("preco"));
				destino.setQuantidade(result.getInt("quantidade"));
				Destino.add(destino);

			}
			
			System.out.println("\n*** Lista de destinos exibida com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Destino;
	}

	public void updateDestination(Destination destino) {
		String strSQL = "UPDATE destination SET nome = ?, categoria = ?, condicao = ?, preco = ?, quantidade = ? WHERE id_destino = ?";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getCategoria());
			pstm.setString(3, destino.getCondicao());
			pstm.setFloat(4, destino.getPreco());
			pstm.setInt(5, destino.getQuantidade());
			pstm.executeUpdate();

			System.out.println("\n*** Destino atualizado com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteDestination(int id) {
		String strSQL = "DELETE FROM destination WHERE id_destino = ?";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, id);
			pstm.executeUpdate();

			System.out.println("\n*** Destino excluído com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Destination searchID(int id) {
		String strSQL = "SELECT * FROM destination WHERE id_destino = ?";
		Destination destino = null;

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, id);
			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				destino = new Destination();
				destino.setId_destino(result.getInt("id_destino"));
				destino.setNome(result.getString("nome"));
				destino.setCategoria(result.getString("categoria"));
				destino.setCondicao(result.getString("condicao"));
				destino.setPreco(result.getFloat("preco"));
				destino.setQuantidade(result.getInt("quantidade"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return destino;
	}

	public Destination searchNAME(String nome) {
		String strSQL = "SELECT * FROM destination WHERE name = ?";
		Destination destino = null;

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setString(1, nome);
			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				destino = new Destination();
				destino.setId_destino(result.getInt("id_destino"));
				destino.setNome(result.getString("nome"));
				destino.setCategoria(result.getString("categoria"));
				destino.setCondicao(result.getString("condicao"));
				destino.setPreco(result.getFloat("preco"));
				destino.setQuantidade(result.getInt("quantidade"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return destino;
	}

	public void endConnection() {
		
		try {
			if (pstm != null) {
				pstm.close();
			}

			if (conn != null && !conn.isClosed()) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}