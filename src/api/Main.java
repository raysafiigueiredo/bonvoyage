package connection_sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import principal.DAO.ConsultaDAO;
import principal.DAO.MedicoDAO;
import principal.DAO.PacienteDAO;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MedicoDAO medicoDAO = new MedicoDAO();
		PacienteDAO pacienteDAO = new PacienteDAO();
		ConsultaDAO consultaDAO = new ConsultaDAO();

		while (true) {
			System.out.println("\nSistema de Gestão de Consultas Médicas");
			System.out.println("1. Cadastrar Medico");
			System.out.println("2. Listar Medicos");
			System.out.println("3. Atualizar Medico");
			System.out.println("4. Excluir Medico");
			System.out.println("5. Cadastrar Paciente");
			System.out.println("6. Listar Pacientes");
			System.out.println("7. Atualizar Paciente");
			System.out.println("8. Excluir Paciente");
			System.out.println("9. Cadastrar Consulta");
			System.out.println("10. Listar Consultas");
			System.out.println("11. Atualizar Consulta");
			System.out.println("12. Excluir Consulta");
			System.out.println("13. Sair");
			System.out.print("Escolha uma opção: ");

			int opcao = sc.nextInt();

			switch (opcao) {
			
			case 1:
				// Cadastrar Medico
				Medico medico = new Medico();
				System.out.print("Nome do Medico: ");
				sc.nextLine(); // Limpar o buffer do teclado
				medico.setNome(sc.nextLine());
				System.out.print("Especialidade: ");
				medico.setEspecialidade(sc.nextLine());
				medicoDAO.criarMedico(medico);
				System.out.println("Medico cadastrado com sucesso!");
				break;

			case 2:
				// Listar Medicos
				List<Medico> medicos = medicoDAO.listarMedicos();
				System.out.println("Lista de Medicos:");
				for (Medico m : medicos) {
					System.out.println(
							"ID: " + m.getId() + ", Nome: " + m.getNome() + ", Especialidade: " + m.getEspecialidade());
				}
				break;

			case 3:
				// Atualizar Medico
				System.out.print("ID do Medico para atualização: ");
				int medicoIdAtualizar = sc.nextInt();
				Medico medicoAtualizar = medicoDAO.buscarMedico(medicoIdAtualizar);
				if (medicoAtualizar != null) {
					System.out.print("Novo Nome do Medico: ");
					sc.nextLine(); // Limpar o buffer do teclado
					medicoAtualizar.setNome(sc.nextLine());
					System.out.print("Nova Especialidade: ");
					medicoAtualizar.setEspecialidade(sc.nextLine());
					medicoDAO.atualizarMedico(medicoAtualizar);
					System.out.println("Medico atualizado com sucesso!");
				} else {
					System.out.println("Medico não encontrado.");
				}
				break;

			case 4:
				// Excluir Medico
				System.out.print("ID do Medico para exclusão: ");
				int medicoIdExcluir = sc.nextInt();
				Medico medicoExcluir = medicoDAO.buscarMedico(medicoIdExcluir);
				if (medicoExcluir != null) {
					medicoDAO.excluirMedico(medicoIdExcluir);
					System.out.println("Medico excluído com sucesso!");
				} else {
					System.out.println("Medico não encontrado.");
				}
				break;

			case 5:
				// Cadastrar Paciente
				Paciente paciente = new Paciente();
				System.out.print("Nome do Paciente: ");
				sc.nextLine(); // Limpar o buffer do teclado
				paciente.setNome(sc.nextLine());
				System.out.print("Idade: ");
				paciente.setIdade(sc.nextInt());
				pacienteDAO.criarPaciente(paciente);
				System.out.println("Paciente cadastrado com sucesso!");
				break;

			case 6:
				// Listar Pacientes
				List<Paciente> pacientes = pacienteDAO.listarPaciente();
				System.out.println("Lista de Pacientes:");
				for (Paciente p : pacientes) {
					System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Idade: " + p.getIdade());
				}
				break;

			case 7:
				// Atualizar Paciente
				System.out.print("ID do Paciente para atualização: ");
				int pacienteIdAtualizar = sc.nextInt();
				Paciente pacienteAtualizar = pacienteDAO.buscarPaciente(pacienteIdAtualizar);
				if (pacienteAtualizar != null) {
					System.out.print("Novo Nome do Paciente: ");
					sc.nextLine(); // Limpar o buffer do teclado
					pacienteAtualizar.setNome(sc.nextLine());
					System.out.print("Nova Idade: ");
					pacienteAtualizar.setIdade(sc.nextInt());
					pacienteDAO.atualizarPaciente(pacienteAtualizar);
					System.out.println("Paciente atualizado com sucesso!");
				} else {
					System.out.println("Paciente não encontrado.");
				}
				break;

			case 8:
				// Excluir Paciente
				System.out.print("ID do Paciente para exclusão: ");
				int pacienteIdExcluir = sc.nextInt();
				Paciente pacienteExcluir = pacienteDAO.buscarPaciente(pacienteIdExcluir);
				if (pacienteExcluir != null) {
					pacienteDAO.excluirPaciente(pacienteIdExcluir);
					System.out.println("Paciente excluído com sucesso!");
				} else {
					System.out.println("Paciente não encontrado.");
				}
				break;

			case 9:
				// Cadastrar Consulta
				Consulta consulta = new Consulta();
				System.out.print("ID do Medico: ");
				int medicoId = sc.nextInt();
				Medico medicoConsulta = medicoDAO.buscarMedico(medicoId);
				if (medicoConsulta != null) {
					consulta.setMedico(medicoConsulta);
					System.out.print("ID do Paciente: ");
					int pacienteId = sc.nextInt();
					Paciente pacienteConsulta = pacienteDAO.buscarPaciente(pacienteId);
					if (pacienteConsulta != null) {
						consulta.setPaciente(pacienteConsulta);
						System.out.print("Data da Consulta (dd/mm/yyyy): ");
						String dataString = sc.next();
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date dataConsulta = sdf.parse(dataString);
							consulta.setDataConsulta(dataConsulta);
							consultaDAO.criarConsulta(consulta);
							System.out.println("Consulta cadastrada com sucesso!");
						} catch (ParseException e) {
							System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
						}
					} else {
						System.out.println("Paciente não encontrado.");
					}
				} else {
					System.out.println("Medico não encontrado.");
				}
				break;

			case 10:
				// Listar Consultas
				List<Consulta> consultas = consultaDAO.listarConsultas();
				System.out.println("Lista de Consultas:");
				for (Consulta c : consultas) {
					System.out.println("ID: " + c.getId() + ", Medico: " + c.getMedico().getNome() + ", Paciente: "
							+ c.getPaciente().getNome() + ", Data: " + c.getDataConsulta());
				}
				break;

			case 11:
				// Atualizar Consulta
				System.out.print("ID da Consulta para atualização: ");
				int consultaId = sc.nextInt();
				Consulta consultaAtualizar = consultaDAO.buscarConsulta(consultaId);
				if (consultaAtualizar != null) {
					System.out.print("Nova Data da Consulta (dd/mm/yyyy): ");
					String novaDataString = sc.next();
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date novaDataConsulta = sdf.parse(novaDataString);
						consultaAtualizar.setDataConsulta(novaDataConsulta);
						consultaDAO.atualizarConsulta(consultaAtualizar);
						System.out.println("Consulta atualizada com sucesso!");
					} catch (ParseException e) {
						System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
					}
				} else {
					System.out.println("Consulta não encontrada.");
				}
				break;

			case 12:
				// Excluir Consulta
				System.out.print("ID da Consulta para exclusão: ");
				int consultaIdExcluir = sc.nextInt();
				Consulta consultaExcluir = consultaDAO.buscarConsulta(consultaIdExcluir);
				if (consultaExcluir != null) {
					consultaDAO.excluirConsulta(consultaIdExcluir);
					System.out.println("Consulta excluída com sucesso!");
				} else {
					System.out.println("Consulta não encontrada.");
				}
				break;

			case 13:
				// Sair
				System.out.println("Saindo do sistema...");
				consultaDAO.endConnection();
				pacienteDAO.endConnection();
				medicoDAO.endConnection();
				sc.close();
				System.exit(0);

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}
}
