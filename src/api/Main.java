package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.DestinoDAO;
import dao.ReservaDAO;
import model.Cliente;
import model.Destino;
import model.Reserva;

public class main {

	public static void welcome() throws ParseException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Olá, seja muito bem vindo(a)!");
		System.out.print("Antes de começar, digite seu nome: ");

		System.out.println("\nOlá " + sc.next() + ", muito prazer em conhecer você.");
		System.out.println(
				"Meu nome é Tutti™, sou sua assistente virtual aqui na BonVoyage™!");

		menuPrincipal();
	}

	public static void menuPrincipal() throws ParseException {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== MENU PRINCIPAL =====\n");
			System.out.println("    1. Menu cliente	");
			System.out.println("    2. Menu destino	");
			System.out.println("    3. Menu reserva	");
			System.out.println("    0. SAIR			");
			System.out.println("\n========================");

			System.out.print("Escolha uma opção: ");
			switch (sc.nextInt()) {

			case 1:
				System.out.println("\n===== MENU CLIENTE =====\n");
				menuCliente();
				break;

			case 2:
				System.out.println("\n===== MENU DESTINO =====\n");
				menuDestino();
				break;

			case 3:
				System.out.println("\n===== MENU RESERVA =====\n");
				menuReserva();
				break;

			case 0:
				System.out.println("\n===== ENCERRAR CONEXÕES =====\n");
				break;

			default:
			}
		}
	}

	public static void menuCliente() throws ParseException {

		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();

		while (true) {
			System.out.println("    1. Cadastrar");
			System.out.println("    2. Excluir	");
			System.out.println("    3. Atualizar");
			System.out.println("    4. Mostrar	");
			System.out.println("    5. Buscar	");
			System.out.println("    6. Logar	");
			System.out.println("    0. Sair		");
			System.out.println("\n========================");

			System.out.print("Escolha uma opção: ");
			switch (sc.nextInt()) {

			case 1: {
				System.out.println("Nome: ");
				cliente.setNome(sc.next());

				System.out.println("Nº documento: ");
				cliente.setDocumento(sc.next());

				System.out.println("Telefone: ");
				cliente.setTelefone(sc.next());

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Data de nascimento: ");
				Date data = sdf.parse(sc.next());
				cliente.setNascimento(data);

				System.out.println("Cadastre um endereço de e-mail: ");
				cliente.setEmail(sc.next());

				System.out.println("Cadastre uma senha: ");
				cliente.setSenha(sc.next());

				clienteDAO.creat(cliente);
				break;
			}

			case 2: {
				System.out.println("Digite o CPF do cliente para exclusao: ");

				try {
					sc.nextLine();
					clienteDAO.delete(sc.next());

				} catch (Exception e) {
					e.getMessage();
					System.out.println("Nenhum contato para excluir ");
				}
				break;
			}

			case 3: {
				System.out.println("Nome: ");
				cliente.setNome(sc.next());

				System.out.println("Nº documento: ");
				cliente.setDocumento(sc.next());

				System.out.println("Telefone: ");
				cliente.setTelefone(sc.next());

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Data de nascimento: ");
				Date data = sdf.parse(sc.next());
				cliente.setNascimento(data);

				System.out.println("Cadastre um endereço de e-mail: ");
				cliente.setEmail(sc.next());

				System.out.println("Cadastre uma senha: ");
				cliente.setSenha(sc.next());
				clienteDAO.update(cliente);
				break;
			}

			case 4: {
				for (Cliente c : clienteDAO.read()) {
					System.out.println("ID CLIENTE: " + c.getId_cliente());
					System.out.println("NOME: " + c.getNome());
					System.out.println("TELEFONE: " + c.getTelefone());
					System.out.println("CPF: " + c.getDocumento());
					System.out.println("DATA NASCIMENTO: " + c.getNascimento());
					System.out.println("EMAIL: " + c.getEmail());
					System.out.println("----------------------------------- ");
				}

				break;
			}

			case 5: {
				Cliente buscar = new Cliente();
				System.out.print("Digite o Nº do documento para buscar: ");
				buscar = clienteDAO.getClienteByCpf(sc.next());

				System.out.println("ID CLIENTE: " + buscar.getId_cliente());
				System.out.println("NOME: " + buscar.getNome());
				System.out.println("EMAIL: " + buscar.getEmail());
				System.out.println("TELEFONE: " + buscar.getTelefone());
				System.out.println("CPF: " + buscar.getDocumento());
				System.out.println("DATA NASCIMENTO: " + buscar.getNascimento());
				System.out.println("EMAIL: " + buscar.getEmail());
				System.out.println("SENHA: " + buscar.getSenha());
				System.out.println("----------------------------------- ");
				break;
			}

			case 6: {
				Cliente login = new Cliente();

				System.out.print("E-mail: ");
				login = ClienteDAO.buscarClientePorEmail(sc.next());

				System.out.print("Senha: ");

				boolean logado = false;

				if (login != null && login.getSenha().equals(sc.next())) {
					logado = true;
				}

				if (logado) {
					System.out.println("*** Usuário logado com sucesso! ***");
					System.out.println("ID: " + login.getId_cliente());
					System.out.println("NOME: " + login.getNome());
					System.out.println("CPF: " + login.getDocumento());
					System.out.println("E-mail: " + login.getEmail());
					System.out.println("Senha: " + login.getSenha());

				} else {
					logado = false;
					System.out.println("USUÁRIO LOGADO: " + login.isLogado());
					System.out.println("E-mail e/ou senha incorretos.");
				}
				break;
			}

			case 0:
				System.out.println(" ATÉ MAIS... ");
				break;

			default:
				System.out.println("Opção inválida. Tente novamente! ");

			}

		}
	}

	public static void menuDestino() {

		Scanner sc = new Scanner(System.in);
		Destino destino = new Destino();
		DestinoDAO destinoDAO = new DestinoDAO();

		while (true) {
			System.out.println("    1. Cadastrar");
			System.out.println("    2. Excluir	");
			System.out.println("    3. Atualizar");
			System.out.println("    4. Mostrar	");
			System.out.println("    5. Buscar	");
			System.out.println("    0. Sair		");
			System.out.println("\n========================");

			System.out.print("Escolha uma opção: ");
			int menu = sc.nextInt();

			switch (menu) {

			case 1: {
				System.out.print("Nome destino: ");
				String nome = sc.next();
				destino.setNomeDestino(nome);

				System.out.println("Digite o PREÇO do destino:");
				Float precoDestino = sc.nextFloat();
				destino.setPrecoUnit(precoDestino);

				System.out.println("Digite a Classe do destino (A), (B) OU (C):");
				String categoriaDestino = sc.next();
				destino.setCategoriaDestino(categoriaDestino);

				System.out.println("Digite a QUANTIDADE:");
				int qtdDisponivel = sc.nextInt();
				destino.setQtdDisponivel(qtdDisponivel);

				System.out.println("Digite a CONDIÇÃO VOO TIPO (DIRETO) OU (ESCALA):");
				String condicao = sc.next();
				destino.setCondicao(condicao);

				destinoDAO.save(destino);
				break;
			}

			case 2: {
				System.out.println("Digite o id do destino para exclusao: ");
				int id = sc.nextInt();

				try {
					id = sc.nextInt();
					destinoDAO.removeById(id);

				} catch (Exception e) {
					e.getMessage();
					System.out.println("Nenhum destino para excluir ");
				}
				break;
			}

			case 3: {
				System.out.println("SEGUE LISTA DE DISTINOS CADASTRADOS PARA ATUALIZAÇÃO ");

				for (Destino des : destinoDAO.getDestinos()) {
					System.out.println("ID DESTINO: " + des.getIdDestino());
					System.out.println("NOME DESTINO: " + des.getNomeDestino());
					System.out.println("PRECO R$: " + des.getPrecoUnit());
					System.out.println("CLASSE: " + des.getCategoriaDestino());
					System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtdDisponivel());
					System.out.println("CONDIÇÃO DO VOO: " + des.getCondicao());
					System.out.println("----------------------------------- ");
				}

				System.out.println(" **** INFORME QUAL DESTINO DESEJA ATUALIZAR **** ");
				System.out.println("Digite o id do destino para atualizar: ");
				int id = sc.nextInt();

				System.out.println("Digite o novo NOME do destino: ");
				String nomeDestino = sc.next();
				destino.setNomeDestino(nomeDestino);

				System.out.println("Digite o NOVO PREÇO: ");
				float precoDestino = sc.nextFloat();
				destino.setPrecoUnit(precoDestino);

				System.out.println("Digite a nova Classe do destino (A), (B) OU (C): ");
				String categoriaDestino = sc.next();
				destino.setCategoriaDestino(categoriaDestino);

				System.out.println("Digite a nova QUANTIDADE DISPONÍVEL para destino: ");
				int qtdDisponivel = sc.nextInt();
				destino.setQtdDisponivel(qtdDisponivel);

				System.out.println("Digite a nova CONDIÇÃO DO VOO TIPO (DIRETO) OU (ESCALA): ");
				String condicao = sc.next();
				destino.setCondicao(condicao);

				destino.setIdDestino(id);
				destinoDAO.update(destino);
			}

			case 4: {
				for (Destino des : destinoDAO.getDestinos()) {

					System.out.println("ID DESTINO: " + des.getIdDestino());
					System.out.println("NOME DESTINO: " + des.getNomeDestino());
					System.out.println("PRECO R$: " + des.getPrecoUnit());
					System.out.println("CLASSE: " + des.getCategoriaDestino());
					System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtdDisponivel());
					System.out.println("CONDIÇÃO DO VOO: " + des.getCondicao());

					System.out.println("----------------------------------- ");

				}
				break;
			}

			case 5: {
				System.out.print("Digite o id para buscar: ");
				int id = sc.nextInt();

				Destino des = new Destino();

				des = destinoDAO.getDestinoById(id);

				System.out.println("NOME DESTINO: " + des.getNomeDestino());
				System.out.println("PRECO R$: " + des.getPrecoUnit());
				System.out.println("CLASSE: " + des.getCategoriaDestino());
				System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtdDisponivel());
				System.out.println("CONDIÇÃO DO VOO: " + des.getCondicao());

				System.out.println("----------------------------------- ");
			}
				break;

			case 0: {
				System.out.println(" === Até logo! === ");
				break;
			}

			default:
				System.out.println("Opção inválida. Tente novamente! ");
			}

		}
	}

	public static void menuReserva() {

		Scanner sc = new Scanner(System.in);
		Reserva reserva = new Reserva();
		Destino destino = new Destino();
		ReservaDAO reservaDAO = new ReservaDAO();
		DestinoDAO destinoDAO = new DestinoDAO();

		while (true) {
			System.out.println("    1. Cadastrar");
			System.out.println("    2. Excluir	");
			System.out.println("    3. Atualizar");
			System.out.println("    4. Mostrar	");
			System.out.println("    5. Buscar	");
			System.out.println("    0. Sair		");
			System.out.println("\n========================");

			System.out.print("Escolha uma opção: ");
			int menu = sc.nextInt();

			switch (menu) {

			case 1: {
				System.out.println("===== Cadastrar reserva! =====\n");

				reserva.setDataReserva(new Date());
				System.out.print("ID do cliente: ");
				int id = sc.nextInt();
				reserva.setIdCliente(id);

				System.out.print("ID do destino: ");
				id = sc.nextInt();

				destino = destinoDAO.getDestinoById(id);
				System.out.println(" --- DESTINO SELECIONADO --- ");
				System.out.println("NOME DESTINO: " + destino.getNomeDestino());
				System.out.println("PRECO R$: " + destino.getPrecoUnit());
				System.out.println("QUANTIDADE DISPONÍVEL: " + destino.getQtdDisponivel());
				reserva.setIdDestino(id);

				System.out.print("Digite a quantidade de reserva: ");
				int qtd = sc.nextInt();
				reserva.setQuantReservada(qtd);

				System.out.print("Digite o 'preço' total da reserva: ");
				Float total = sc.nextFloat();
				reserva.setPrecoTotal(total);

				System.out.println("Digite o 'status' (aprovado/negado):");
				String status = sc.next();
				reserva.setStatusPedido(status);

				System.out.println("Forma de pagamento (crédito/debito/pix):");
				String formaPagamento = sc.next();
				reserva.setPagamento(formaPagamento);

				reservaDAO.save(reserva);
				break;
			}

			case 2: {
				System.out.println("===== Excluir reserva! =====\n");
				System.out.println("ID: ");
				int id = sc.nextInt();

				try {
					id = sc.nextInt();
					reservaDAO.removeById(id);

				} catch (Exception e) {
					// e.getMessage();
					System.out.println("Nenhum pedido para excluir ");
				}
				break;
			}

			case 3: {
				System.out.println("===== Atualizar reserva! =====\n");

				for (Reserva ped : reservaDAO.getPedidos()) {
					System.out.println("ID RESERVA: " + ped.getIdReserva());
					System.out.println("ID CLIENTE: " + ped.getIdCliente());
					System.out.println("ID DESTINO: " + ped.getIdDestino());
					System.out.println("QUANTIDADE RESERVADA: " + ped.getQuantReservada());
					System.out.println("PREÇO TOTAL R$: " + ped.getPrecoTotal());
					System.out.println("FORMA DE PAGAMENTO: " + ped.getPagamento());
					System.out.println("DATA DO PEDIDO: " + ped.getDataReserva());
					System.out.println("STATUS RESERVA: " + ped.getStatusPedido());

					System.out.println("----------------------------------- ");
				}

				System.out.println(" **** INFORME QUAL RESERVA DESEJA ATUALIZAR **** ");
				System.out.println("ID: ");
				int id = sc.nextInt();

				System.out.println("Quantidade: ");
				int qtd = sc.nextInt();
				reserva.setQuantReservada(qtd);

				System.out.println("Preço: ");
				float total = sc.nextFloat();
				reserva.setPrecoTotal(total);

				System.out.println("Forma de pagamento: ");
				String formaPagamento = sc.next();
				reserva.setPagamento(formaPagamento);

				System.out.println("Status: ");
				String status = sc.next();
				reserva.setStatusPedido(status);

				reserva.setIdReserva(id);
				reservaDAO.update(reserva);
			}

			case 4: {
				System.out.println("===== Mostrar reserva! =====\n");
				for (Reserva ped : reservaDAO.getPedidos()) {
					System.out.println("ID RESERVA: " + ped.getIdReserva());
					System.out.println("ID CLIENTE: " + ped.getIdCliente());
					System.out.println("ID DESTINO: " + ped.getIdDestino());
					System.out.println("QUANTIDADE RESERVADA: " + ped.getQuantReservada());
					System.out.println("PREÇO TOTAL R$: " + ped.getPrecoTotal());
					System.out.println("FORMA DE PAGAMENTO: " + ped.getPagamento());
					System.out.println("DATA DO PEDIDO: " + ped.getDataReserva());
					System.out.println("STATUS RESERVA: " + ped.getStatusPedido());
					System.out.println("----------------------------------- ");
				}
				break;
			}

			case 5: {
				System.out.println("===== Buscar reserva! =====\n");
				System.out.print("ID reserva: ");
				int id = sc.nextInt();

				Reserva ped = new Reserva();

				ped = reservaDAO.getPedidoById(id);

				System.out.println("*** SEGUE LISTA DE RESERVAS SELECIONADA ***");
				System.out.println("ID RESERVA: " + ped.getIdReserva());
				System.out.println("ID CLIENTE: " + ped.getIdCliente());
				System.out.println("ID DESTINO: " + ped.getIdDestino());
				System.out.println("QUANTIDADE RESERVADA: " + ped.getQuantReservada());
				System.out.println("PREÇO TOTAL R$: " + ped.getPrecoTotal());
				System.out.println("FORMA DE PAGAMENTO: " + ped.getPagamento());
				System.out.println("DATA DO PEDIDO: " + ped.getDataReserva());
				System.out.println("STATUS RESERVA: " + ped.getStatusPedido());

				System.out.println("----------------------------------- ");
			}
				break;

			case 0: {
				System.out.println(" === Agradecemos pela preferência. Tchau💕 === ");
				break;
			}

			default:
				System.out.println("Opção inválida. Tente novamente! ");
			}

		}

	}

	public static void main(String[] args) throws ParseException {

		welcome();
	}

}
