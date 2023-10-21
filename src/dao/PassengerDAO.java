package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Passenger;

public class PassengerDAO {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet result = null;

	public PassengerDAO() {

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void creatPassenger(Passenger passageiro) {

		String sql = "INSERT INTO passenger (nome, nascimento, documento, genero, telefone, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, passageiro.getNome());
			pstm.setDate(2, new Date(passageiro.getNascimento().getTime()));
			pstm.setInt(3, passageiro.getDocumento());
			pstm.setString(4, passageiro.getGenero());
			pstm.setString(5, passageiro.getTelefone());
			pstm.setString(6, passageiro.getEmail());
			pstm.setString(7, passageiro.getSenha());
			pstm.executeUpdate();

			System.out.println("\n*** Passageiro cadastrado com sucesso! ***\n");

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

	public List<Passenger> readPassenger() {

		String sql = "SELECT * FROM passenger";

		List<Passenger> Passageiro = new ArrayList<Passenger>();

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				Passenger passageiro = new Passenger();
				passageiro.setId_passageiro(result.getInt("id_passageiro"));
				passageiro.setNome(result.getString("nome"));
				passageiro.setNascimento(result.getDate("nascimento"));
				passageiro.setDocumento(result.getInt("documento"));
				passageiro.setGenero(result.getString("genero"));
				passageiro.setTelefone(result.getString("telefone"));
				passageiro.setEmail(result.getString("email"));
				passageiro.setSenha(result.getString("senha"));
				Passageiro.add(passageiro);
			}
			
			System.out.println("\n*** Lista de passageiros exibida com sucesso! ***\n");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (result != null) {
					result.close();
				}

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
		
		return Passageiro;
	}

	public void updatePassenger(Passenger passageiro) {
		String sql = "UPDATE passenger SET nome = ?, nascimento = ?, documento = ?, genero = ?, telefone = ?, email = ?, senha = ?,"
				+ "WHERE id_passageiro = ?";

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, passageiro.getNome());
			pstm.setDate(2, new Date(passageiro.getNascimento().getTime()));
			pstm.setInt(3, passageiro.getDocumento());
			pstm.setString(4, passageiro.getGenero());
			pstm.setString(5, passageiro.getTelefone());
			pstm.setString(6, passageiro.getEmail());
			pstm.setString(7, passageiro.getSenha());
			pstm.executeUpdate();

			System.out.println("\n*** Passageiro atualizado com sucesso! ***\n");

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

	public void deletePassenger(int id) {
		
		String sql = "DELETE FROM passenger WHERE id_passageiro = ?";

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.executeUpdate();

			System.out.println("\n*** Passageiro excluído com sucesso! ***\n");

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

	public Passenger searchID(int id) {
		
		String strSQL = "SELECT * FROM passenger WHERE id_passageiro = ?";
		
		Passenger passageiro = null;

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, id);
			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				passageiro = new Passenger();
				passageiro.setId_passageiro(result.getInt("id_passageiro"));
				passageiro.setNome(result.getString("nome"));
				passageiro.setNascimento(result.getDate("nascimento"));
				passageiro.setDocumento(result.getInt("documento"));
				passageiro.setGenero(result.getString("genero"));
				passageiro.setTelefone(result.getString("telefone"));
				passageiro.setEmail(result.getString("email"));
				passageiro.setSenha(result.getString("senha"));
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
		
		return passageiro;
	}

	public Passenger searchNAME(String nome) {
		
		String sql = "SELECT * FROM passenger WHERE name = ?";
		
		Passenger passageiro = null;

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setString(1, nome);
			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				passageiro = new Passenger();
				passageiro.setId_passageiro(result.getInt("id_passageiro"));
				passageiro.setNome(result.getString("nome"));
				passageiro.setNascimento(result.getDate("nascimento"));
				passageiro.setDocumento(result.getInt("documento"));
				passageiro.setGenero(result.getString("genero"));
				passageiro.setTelefone(result.getString("telefone"));
				passageiro.setEmail(result.getString("email"));
				passageiro.setSenha(result.getString("senha"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (result != null) {
					result.close();
				}

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
		
		return passageiro;
	}

	public void endConnection() {
		try {
			if (result != null) {
				result.close();
			}

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