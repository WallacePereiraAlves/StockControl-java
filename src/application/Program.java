package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.enums.ProductCategory;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		String option = "";

		while (!option.equals("sair")) {
			displayMenu();
			System.out.print("Digite uma opção: ");
			option = sc.nextLine().toLowerCase();

			switch (option) {

			case "1":
				registerProduct(sc,list);
				break;
			case "2":
				increaseStock(sc,list);
				break;
			case "3":
				decreaseStock(sc, list);
				break;
			case "4":
				deleteProduct(sc, list);
				break;
			case "5":
				showProductList(list);
				break;
			case "sair":
				break;
				
			default:
				System.out.println();
				System.out.println("Opção inválida. Por favor, escolha uma opção válida: ");
				clearConsole();
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
	
	private static void registerProduct(Scanner sc, List<Product> list) {
		
		System.out.println();
		System.out.println("Entre com os dados do produto: ");
		System.out.println();
		
		System.out.print("Nome: ");
		String name = sc.nextLine();

		System.out.print("Preço: ");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.print("Quantidade no estoque: ");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Categoria (ALIMENTO, BEBIDA, ELETRONICO, VESTUARIO, LIVRO, OUTRO): ");
	    String categoryStr = sc.nextLine().toUpperCase();
	    
	    ProductCategory category = ProductCategory.valueOf(categoryStr);
	    
	    Product newProduct = new Product(name, price, quantity, category);
		
		list.add(newProduct);
		
		System.out.println();
		System.out.println("Produto adicionado com sucesso!");
		clearConsole();
	}
	
	private static void increaseStock(Scanner sc, List<Product> list) {
		
		System.out.println();
		System.out.print("Digite o nome do produto: ");
		String productName = sc.nextLine();
		boolean productFound = false;

		for (Product product : list) {

			if (product.getName().equalsIgnoreCase(productName)) {
				System.out.print("Digite a quantidade a ser adicionada no estoque: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				product.AddProducts(quantity);
				System.out.println();
				System.out.println("Estoque atualizado.");
				productFound = true;
				clearConsole();
				break;
			}
		}

		if (!productFound) {
			System.out.println("Produto não encontrado.");
			clearConsole();
		}

	}
	
	private static void decreaseStock(Scanner sc, List<Product> list) {
		System.out.println();
		System.out.print("Digite o nome do produto: ");
		String productName = sc.nextLine();
		boolean productFound = false;
		
		for (Product product : list) {

			if (product.getName().equalsIgnoreCase(productName)) {
				System.out.print("Digite a quantidade a ser retirada do estoque: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				product.RemoveProducts(quantity);
				System.out.println();
				System.out.println("Estoque atualizado.");
				productFound = true;
				clearConsole();
				break;
			}
		}

		if (!productFound) {
			System.out.println("Produto não encontrado.");
			clearConsole();
		}
		
	}
	
	private static void deleteProduct(Scanner sc, List<Product> list) {
		System.out.println();
		System.out.print("Digite o nome do produto que deseja excluir: ");
		String productName = sc.nextLine();
		
		Product removePdct = null;
		
		for(Product product : list) {
			
			if(product.getName().equalsIgnoreCase(productName)) {
				removePdct = product; 
				break;
			}
			
		}
		
		if(removePdct != null) {
			list.remove(removePdct);
			System.out.println("Produto removido com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
		
		clearConsole();
		
	}
	
	private static void showProductList(List<Product> list) {
		System.out.println();
		System.out.println("Lista de produtos cadastrados: ");
		System.out.println();
		for(Product product : list) {
			System.out.println(product);
		}
		
		clearConsole();
	}
	
	public static void clearConsole() {
		System.out.println("\n\n\n");
	}
	
	
}
