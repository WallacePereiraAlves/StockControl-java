package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Product produto = new Product(); 
		
		System.out.println("Entre com os dados do produto: ");
		
		System.out.print("Nome: ");
		String name = sc.nextLine();
		
		System.out.print("Preço: ");
		double price = sc.nextDouble();		
		
		produto = new Product(name, price);
		
		produto.setName("Computador");
		System.out.println("Atualização dos dados: " + produto.getName());
		produto.setPrice(1200.00);
		System.out.println("Atualização dos dados: " + produto.getPrice());
		
		System.out.println(); 
		System.out.println("Dados do produto: " + produto);
		
		System.out.println();
		System.out.println("Entre com o número de produtos para adicionar no estoque: ");
		int quantity = sc.nextInt();
		produto.AddProducts(quantity);
		
		System.out.println(); 
		System.out.println("Atualização dos dados: " + produto);
		
		System.out.println();
		System.out.println("Entre com o número de produtos para remover do estoque: ");
		quantity = sc.nextInt();
		produto.RemoveProducts(quantity);
		
		System.out.println(); 
		System.out.println("Atualização dos dados: " + produto);
		
		sc.close();
	}
}
