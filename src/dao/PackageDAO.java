package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Package;

public class PackageDAO {
	private Connection conn = null;
	PreparedStatement pstm = null;

	public PackageDAO() {

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void creatPackage(Package pacote) {
		String strSQL = "INSERT INTO package (nome, categoria, condicao, preco, promocao, quantidade) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setString(1, pacote.getNome());
			pstm.setString(2, pacote.getCategoria());
			pstm.setString(3, pacote.getCondicao());
			pstm.setFloat(4, pacote.getPreco());
			pstm.setFloat(5, pacote.getPromocao());
			pstm.setInt(6, pacote.getQuantidade());
			pstm.executeUpdate();

			System.out.println("\n*** Pacote cadastrado com sucesso! ***\n");

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

	public List<Package> readPackage() {
		String strSQL = "SELECT * FROM package";

		List<Package> Pacote = new ArrayList<Package>();

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				Package pacote = new Package();
				pacote.setId_pacote(result.getInt("id_pacote"));
				pacote.setNome(result.getString("nome"));
				pacote.setCategoria(result.getString("categoria"));
				pacote.setCondicao(result.getString("condicao"));
				pacote.setPreco(result.getFloat("preco"));
				pacote.setPromocao(result.getFloat("promocao"));
				pacote.setQuantidade(result.getInt("quantidade"));
				Pacote.add(pacote);
			}

			System.out.println("\n*** Lista de pacotes exibida com sucesso! ***\n");

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

		return Pacote;
	}

	public void updatePackage(Package pacote) {
		String strSQL = "UPDATE package SET nome = ?, categoria = ?, condicao = ?, preco = ?, promocao = ?, quantidade = ? WHERE id_destino = ?";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setString(1, pacote.getNome());
			pstm.setString(2, pacote.getCategoria());
			pstm.setString(3, pacote.getCondicao());
			pstm.setFloat(4, pacote.getPreco());
			pstm.setFloat(5, pacote.getPromocao());
			pstm.setInt(6, pacote.getQuantidade());
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

	public void deletePackage(int id) {
		String strSQL = "DELETE FROM package WHERE id_pacote = ?";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, id);
			pstm.executeUpdate();

			System.out.println("\n*** Pacote excluído com sucesso! ***\n");

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

	public Package searchID(int id) {
		String strSQL = "SELECT * FROM package WHERE id_pacote = ?";
		Package pacote = null;

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, id);
			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				pacote = new Package();
				pacote.setId_pacote(result.getInt("id_pacote"));
				pacote.setNome(result.getString("nome"));
				pacote.setCategoria(result.getString("categoria"));
				pacote.setCondicao(result.getString("condicao"));
				pacote.setPreco(result.getFloat("preco"));
				pacote.setPromocao(result.getFloat("promocao"));
				pacote.setQuantidade(result.getInt("quantidade"));
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
		return pacote;
	}

	public Package searchNAME(String nome) {
		String strSQL = "SELECT * FROM package WHERE name = ?";
		Package pacote = null;

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setString(1, nome);
			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				pacote = new Package();
				pacote.setId_pacote(result.getInt("id_pacote"));
				pacote.setNome(result.getString("nome"));
				pacote.setCategoria(result.getString("categoria"));
				pacote.setCondicao(result.getString("condicao"));
				pacote.setPreco(result.getFloat("preco"));
				pacote.setPromocao(result.getFloat("promocao"));
				pacote.setQuantidade(result.getInt("quantidade"));
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
		return pacote;
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