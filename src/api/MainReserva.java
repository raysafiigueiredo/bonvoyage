package api;

import java.util.List;
import java.util.Scanner;

import dao.DestinationDAO;
import dao.PackageDAO;
import dao.PassageiroDAO;
import dao.ReservationDAO;
import model.Passenger;
import model.Destination;
import model.Medico;
import model.Package;
import model.Reservation;

public class MainReserva {
	public static void main(String[] args) {
		PassageiroDAO passageiroDAO = new PassageiroDAO();
		ReservationDAO reservationDAO = new ReservationDAO();
		PackageDAO packageDAO = new PackageDAO();
		DestinationDAO destinationDAO = new DestinationDAO();

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\n============================== RESERVAS =================================\n");
			System.out.println("1-CADASTRAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 1:
				Reservation newReservation = new Reservation();
                
				System.out.print("Digite o ID do pacote: ");
                sc.nextLine();
                newReservation.setPacote(sc.nextInt());

				System.out.print("Digite o ID do destino: ");
				int cad_destino = sc.nextInt();
				sc.nextLine();

				System.out.println("Digite o ID do passageiro: ");
				int cad_passageiro = sc.nextInt();
				sc.nextLine();

				System.out.print("Digite a data de entrada (check-in): ");
				String cad_entrada = sc.nextLine();

				System.out.print("Digite a data de saída (check-out): ");
				String cad_saida = sc.nextLine();

				System.out.print("Digite o status da reserva: ");
				boolean cad_status = sc.nextBoolean();


				reservationDAO.cadastrarReserva(cadastrarReserva);
				break;

			case 2:
				List<Reservation> Reservation = reservationDAO.consultarReserva();
				System.out.println("===== Lista de Reservas =====");

				for (Reservation r : reservationDAO.consultarReserva()) {
					System.out.println(r.toString());

				}

				break;

			case 3:
				Reservation updateReserva = new Reservation();
				
				System.out.print("Digite o id da reserva: ");
				sc.nextLine();
				int teclado = sc.nextInt();
				updateReserva.setId_reserva(teclado);

				System.out.print("Digite o ID do pacote: ");
				sc.nextLine();
				updateReserva.setId_reserva(teclado);

				System.out.print("Digite o ID do destino: ");
				int update_destino = sc.nextInt();
				sc.nextLine();

				System.out.println("Digite o ID do passageiro: ");
				int update_passageiro = sc.nextInt();
				sc.nextLine();

				System.out.print("Digite a data de entrada (check-in): ");
				String update_entrada = sc.nextLine();

				System.out.print("Digite a data de saída (check-out): ");
				String update_saida = sc.nextLine();

				System.out.print("Digite o status da reserva: ");
				boolean update_status = sc.nextBoolean();

				Package updatePacote = packageDAO.buscarIdPacote(cad_pacote);
				Destination updateDestino = destinationDAO.buscarIdDestino(cad_destino);
				Passenger updatePassageiro = passageiroDAO.buscarIdPassageiro(cad_passageiro);

				
				reservationDAO.atualizarReserva(updateReserva);
				break;

			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				reservationDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Reservation reserva3 = reservationDAO.readById(id);

				System.out.println(reserva3.toString());
				break;

			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}