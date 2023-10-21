package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.DestinationDAO;
import dao.ReservationDAO;
import model.Destination;
import model.Passenger;
import model.Reservation;

public class ReservationMAIN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DestinationDAO destinoDAO = new DestinationDAO();
		ReservationDAO reservaDAO = new ReservationDAO();

		while (true) {
			System.out.println("===== RESERVA =====");
			System.out.println(" [1] Atualizar");
			System.out.println(" [2] Buscar");
			System.out.println(" [3] Cadastrar");
			System.out.println(" [4] Consultar");
			System.out.println(" [5] Deletar");
			System.out.println(" [0] Sair");

			System.out.print("\nEscolha uma opção: ");

			int menu = sc.nextInt();
			switch (menu) {

			case 0:
				System.out.println(" === Agradecemos pela preferência! === ");
				break;

			case 1:
				System.out.println("========== ATUALIZAR RESERVAS ==========\n");

				System.out.print("Digite o ID: ");
				sc.nextLine();
				int id = sc.nextInt();

				Reservation atualizarReserva = reservaDAO.searchID(id);

				if (atualizarReserva != null) {
					System.out.print("Digite a nova data (dd/mm/yyyy): ");
					String data = sc.next();

					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date new_data = sdf.parse(data);
						atualizarReserva.setData(new_data);

						reservaDAO.updateReservation(atualizarReserva);
						System.out.println("Reserva atualizada com sucesso!");

					} catch (ParseException e) {
						System.out.println("Formato de data inválido. Use dd/mm/yyyy.");

					}

				} else {
					System.out.println("Reserva não encontrada.");

				}

				break;

			case 2: {
				List<Reservation> Reservation = reservaDAO.readReservation();
				System.out.println("Lista de Reservas: ");

				for (Reservation r : Reservation) {
					System.out.println("ID: " + r.getId_reserva() + "\nData: " + r.getData());
				}
			}
				break;

			case 3:
				Reservation reserva = new Reservation();
				Destination d = new Destination();
				
				reserva.setData(new Date());

				System.out.print("Digite o id Destino para Reservar: ");
				sc.nextLine();
				id = sc.nextInt();
				
				d = destinoDAO.searchID(id);
				System.out.println(" --- DESTINO SELECIONADO --- ");
				System.out.println("NOME DESTINO: " + d.getNome());
				System.out.println("PRECO R$: " + d.getPreco());
				System.out.println("QUANTIDADE DISPONÍVEL: " + d.getQuantidade());
				reserva.setId_reserva(id);

				System.out.println("Digite o PREÇO TOTAL do RESERVA:");
				Float total = sc.nextFloat();
				reserva.setTotal(total);

				System.out.println("Digite O STATUS DA RESERVA (APROVADO) (NEGADO):");
				boolean status = sc.next() != null;
				reserva.setStatus(status);

				System.out.println("Digite a FORMA DE PAGAMENTO (AVISTA) (PIX) OU (CARTAO):");
				String formaPagamento = sc.next();
				reserva.setPagamento(formaPagamento);

				reservaDAO.createReservation(reserva);

				System.out.println("Reserva cadastrado com sucesso!");

				break;				
			
			case 4:

				List<Reservation> Reservation = reservaDAO.readReservation();
				System.out.println("===== Lista de Reservas =====");

				for (Reservation r : reservaDAO.readReservation()) {
					System.out.println(r.toString());

				}

				for (Reservation r : reservaDAO.readReservation()) {
					System.out.println("ID RESERVA: " + r.getId_reserva());
					System.out.println("ID CLIENTE: " + r.getPassageiro());
					System.out.println("ID DESTINO: " + r.getDestino());
					System.out.println("PREÇO TOTAL R$: " + r.getTotal());
					System.out.println("FORMA DE PAGAMENTO: " + r.getPagamento());
					System.out.println("DATA DO PEDIDO: " + r.getData());
					System.out.println("----------------------------------- ");
				}
				break;

			case 5:
				System.out.println("========== DELETAR RESERVAS ==========\n");

				System.out.print("Digite o ID: ");
				int deletaID = sc.nextInt();

				Reservation deletarReserva = reservaDAO.searchID(deletaID);

				if (deletarReserva != null) {
					reservaDAO.deleteReservation(deletaID);
					System.out.println("*** Reserva excluída com sucesso! ***");

				} else {
					System.out.println("Reserva não encontrada.");

				}

				break;

			default:
				System.out.println("Opcao invalida: ");
			}

		}
	}
}