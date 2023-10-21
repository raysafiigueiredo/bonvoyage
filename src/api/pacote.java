package api;

import java.util.List;
import java.util.Scanner;

import dao.PackageDAO;
import model.Package;

public class pacote {
	public static void main(String[] args) {
		PackageDAO packageDAO = new PackageDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== MENU PACOTE =====\n");
			System.out.println("    1. Cadastrar	");
			System.out.println("    2. Consultar	");
			System.out.println("    3. Buscar ID	");
			System.out.println("    4. Atualizar	");
			System.out.println("    5. Deletar		");
			System.out.println("    0. Sair\n		");

			System.out.print("Escolha uma opção: ");
			int menu = sc.nextInt();

			switch (menu) {

			case 1:
				System.out.println("\n===== CADASTRAR PACOTE =====");

				System.out.print("Nome: ");
				String nome = sc.next();

				System.out.print("Preço: ");
				double preco = sc.nextDouble();

				System.out.print("Valor promocional: ");
				double promocao = sc.nextDouble();

				Package pacote = new Package(nome, preco, promocao);
				packageDAO.cadastrarPacote(pacote);

				System.out.print("");
				System.out.println("Pacote cadastrado com sucesso!");
				break;

			case 2:
				System.out.println("\n===== CONSULTAR PACOTE =====");

				List<Package> Pacote = packageDAO.consultarPacote();

				System.out.println("Lista de Pacotes:");
				for (Package p : packageDAO.consultarPacote()) {
					System.out.println(p.toString());
				}

				break;

			}
		}
	}
}