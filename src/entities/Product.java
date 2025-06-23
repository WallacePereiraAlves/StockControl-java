package entities;

import java.time.LocalDate;
import entities.enums.ProductCategory;

public class Product {

	private static Integer nextId = 1;
	
	private int id;
	private String name;
	private double price;
	private int quantity;
	private ProductCategory category;
	private LocalDate registerDate;
	
	
	public Product() {		
	}
	
	public Product(String name, double price, int quantity, ProductCategory category) {
		this.id = nextId++;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.registerDate = LocalDate.now();
		}  
	
	public int getId() {
		return id;
	}
	   
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() { 
		return quantity;
	}
	
    public ProductCategory getCategory() {
        return category;
    }
    
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    
    public LocalDate getRegisterDate() {
        return registerDate;
    }
    
	public double TotalValueInStock() {
		return price * quantity;
	}
	
	public void AddProducts(int quantity) {
		this.quantity += quantity;
	}
	
	public void RemoveProducts(int quantity) {
		if (quantity <= this.quantity) {
			this.quantity -= quantity;
		} else {
			System.out.println("Erro: Quantidade maior que o estoque disponível.");
		}
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d | %s (%s), $%.2f, %d unidades, Total: $%.2f, Cadastrado em: %s",
                id, name, category, price, quantity, TotalValueInStock(), registerDate);
	}
	
}



