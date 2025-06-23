package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import services.ProductService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		ProductService service = new ProductService(list, sc);
		
		String option = "";

		while (!option.equals("sair")) {
			displayMenu();
			System.out.print("Digite uma opção: ");
			option = sc.nextLine().toLowerCase();

			switch (option) {
			
			case "1": service.registerProduct(); break;
			case "2": service.increaseQuantity(); break;
			case "3": service.decreaseQuantity(); break;
			case "4": service.deleteProduct(); break;
			case "5": service.showProductList(); break;
			case "sair": break;
				
			default:
				System.out.println();
				System.out.println("Opção inválida. Por favor, escolha uma opção válida: ");
				service.clearConsole();
				break;
			}
		}

		System.out.println("Sistema finalizado com sucesso.");
		
		sc.close();
	}
	
	
	private static void displayMenu() {
		System.out.println("------------------------------");
		System.out.println("----- CONTROLE DE ESTOQUE ----");
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("------------ MENU ------------");
		System.out.println();
		System.out.println("1. Adicionar produto");
		System.out.println("2. Adicionar quantidade ao estoque");
		System.out.println("3. Retirar uma quantidade do estoque");
		System.out.println("4. Remover produto");
		System.out.println("5. Ver lista de produtos");
		System.out.println();
		System.out.println("Digite 'sair' para encerrar o programa");
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
	}
}
