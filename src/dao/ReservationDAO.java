package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Reservation;

public class ReservationDAO {
	private Connection conn = null;
	PreparedStatement pstm = null;

	public ReservationDAO() {

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void createReservation(Reservation reserva) {
		String strSQL = "INSERT INTO reservation (id_pacote, id_destino, id_passageiro, data, checkin, checkout, pagamento, total, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, reserva.getPacote().getId_pacote());
			pstm.setInt(2, reserva.getDestino().getId_destino());
			pstm.setInt(3, reserva.getPassageiro().getId_passageiro());
			pstm.setDate(4, new Date(reserva.getData().getTime()));
			pstm.setString(5, reserva.getCheckin());
			pstm.setString(6, reserva.getCheckout());
			pstm.setString(7, reserva.getPagamento());
			pstm.setFloat(8, reserva.getTotal());
			pstm.setBoolean(9, reserva.isStatus());
			pstm.executeUpdate();

			System.out.println("\n*** Reserva cadastrado com sucesso! ***\n");

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

	public List<Reservation> readReservation() {
		String strSQL = "SELECT * FROM reservation";

		List<Reservation> Reservation = new ArrayList<Reservation>();

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			ResultSet result = pstm.executeQuery();

			while (result.next()) {
				Reservation reservation = new Reservation();
				PackageDAO packageDAO = new PackageDAO();
				DestinationDAO destinationDAO = new DestinationDAO();
				PassengerDAO passangerDAO = new PassengerDAO();

				reservation.setId_reserva(result.getInt("id_reserva"));
				reservation.setPacote(packageDAO.searchID(result.getInt("id_pacote")));
				reservation.setDestino(destinationDAO.searchID(result.getInt("id_destino")));
				reservation.setPassageiro(passangerDAO.searchID(result.getInt("id_passageiro")));
				reservation.setData(result.getDate("data"));
				reservation.setCheckin(result.getString("checkin"));
				reservation.setCheckout(result.getString("checkout"));
				reservation.setPagamento(result.getString("pagamento"));
				reservation.setTotal(result.getFloat("total"));
				reservation.setStatus(result.getBoolean("status"));
				Reservation.add(reservation);

			}

			System.out.println("\n*** Lista de reservas exibida com sucesso! ***\n");

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

		return Reservation;
	}

	public void updateReservation(Reservation reserva) {
		String strSQL = "UPDATE reservation SET id_pacote = ?, id_destino = ?, id_passageiro = ?, data = ?, checkin = ?, checkout = ?, pagamento = ?, total = ?, status = ? WHERE id_reserva = ?";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, reserva.getPacote().getId_pacote());
			pstm.setInt(2, reserva.getDestino().getId_destino());
			pstm.setInt(3, reserva.getPassageiro().getId_passageiro());
			pstm.setTimestamp(4, new java.sql.Timestamp(reserva.getData().getTime()));
			pstm.setString(5, reserva.getCheckin());
			pstm.setString(6, reserva.getCheckout());
			pstm.setString(7, reserva.getPagamento());
			pstm.setFloat(8, reserva.getTotal());
			pstm.setBoolean(9, reserva.isStatus());
			pstm.executeUpdate();

			System.out.println("\n*** Reserva atualizado com sucesso! ***\n");

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

	public void deleteReservation(int id) {
		String strSQL = "DELETE FROM reservation WHERE id_reserva = ?";

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, id);
			pstm.executeUpdate();

			System.out.println("\n*** Reserva excluído com sucesso! ***\n");

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

	public Reservation searchID(int id) {
		String strSQL = "SELECT * FROM reservation WHERE id_reserva = ?";
		Reservation reservation = null;

		try (PreparedStatement pstm = conn.prepareStatement(strSQL)) {
			pstm.setInt(1, id);
			ResultSet result = pstm.executeQuery();

			if (result.next()) {
				reservation = new Reservation();
				PackageDAO packageDAO = new PackageDAO();
				DestinationDAO destinationDAO = new DestinationDAO();
				PassengerDAO passangerDAO = new PassengerDAO();
				reservation.setId_reserva(result.getInt("id_reserva"));
				reservation.setPacote(packageDAO.searchID(result.getInt("id_pacote")));
				reservation.setDestino(destinationDAO.searchID(result.getInt("id_destino")));
				reservation.setPassageiro(passangerDAO.searchID(result.getInt("id_passageiro")));
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

		return reservation;
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