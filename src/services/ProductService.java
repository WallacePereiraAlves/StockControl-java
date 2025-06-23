package services;

import java.util.List;
import java.util.Scanner;
import entities.Product;
import entities.enums.ProductCategory;

public class ProductService {
	
	private List<Product> productList;
	private Scanner sc;
	
	public ProductService(List<Product> list, Scanner sc) {
		this.productList = list;
		this.sc = sc;
	}
	
	public void registerProduct() {
		
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
		
	    productList.add(newProduct);
		
		System.out.println();
		System.out.println("Produto adicionado com sucesso!");
		clearConsole();
	}
	
	public void increaseQuantity() {
		
		System.out.println();
		System.out.print("Digite o nome do produto: ");
		String productName = sc.nextLine();
		
		boolean productFound = false;

		for (Product p : productList) {

			if (p.getName().equalsIgnoreCase(productName)) {
				System.out.print("Digite a quantidade a ser adicionada no estoque: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				
				p.addProducts(quantity);
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
	
	public void decreaseQuantity() {
		System.out.println();
		System.out.print("Digite o nome do produto: ");
		String productName = sc.nextLine();
		boolean productFound = false;
		
		for (Product p : productList) {

			if (p.getName().equalsIgnoreCase(productName)) {
				System.out.print("Digite a quantidade a ser retirada do estoque: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				p.removeProducts(quantity);
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
	
	public void deleteProduct() {
		System.out.println();
		System.out.print("Digite o nome do produto que deseja excluir: ");
		String productName = sc.nextLine();
		
		Product toRemove = null;
		
		for(Product p : productList) {
			
			if(p.getName().equalsIgnoreCase(productName)) {
				toRemove = p; 
				break;
			}
			
		}
		
		if(toRemove != null) {
			productList.remove(toRemove);
			System.out.println("Produto removido com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
		
		clearConsole();
		
	}
	
	public void showProductList() {
		System.out.println();
		System.out.println("Lista de produtos cadastrados: ");
		System.out.println();
		for(Product p : productList) {
			System.out.println(p);
		}
		
		clearConsole();
	}
	
	public void clearConsole() {
		System.out.println("\n");
	}
}
