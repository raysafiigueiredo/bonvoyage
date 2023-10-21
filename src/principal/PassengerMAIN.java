package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.PassengerDAO;
import model.Package;
import model.Passenger;

public class PassengerMAIN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PassengerDAO passengerDAO = new PassengerDAO();

		while (true) {
			System.out.println("===== PASSAGEIRO =====");
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

				Passenger atualizarPassageiro = passengerDAO.searchID(id);

				break;

			case 2: {						
				List<Passenger> Passenger = passengerDAO.readPassenger();
				System.out.println("Lista de Reservas: ");

				for (Passenger p : Passenger) {
					System.out.println("ID: " + p.getId_passageiro() + "\nData: " + p.getNascimento());
					System.out.println(p.toString());
				}
				
			}
			
			case 3:
				Passenger passenger = new Passenger();
								
				System.out.print("Nome do Passageiro: ");
				sc.nextLine();
				passenger.setNome(sc.next());
				
				System.out.print("Data de nascimento (dd/mm/yyyy): ");
				sc.nextLine();
				String dataString = sc.next();
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date data_nascimento = sdf.parse(dataString);
					passenger.setNascimento(data_nascimento);
					passengerDAO.creatPassenger(passenger);
				
				} catch (ParseException e) {
					System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
					
				}				
				
				System.out.print("Digite o nº documento: ");
				sc.nextLine();
				passenger.setDocumento(sc.nextInt());
				
				System.out.print("Digite o sexo: ");
				sc.nextLine();
				passenger.setGenero(sc.next());
				
				passengerDAO.creatPassenger(passenger);
				System.out.println("Medico cadastrado com sucesso!");
				break;
				
			default:
				System.out.println("Opcao invalida: ");
			}

		}
	}
}
