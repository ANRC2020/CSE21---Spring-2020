import java.util.Scanner;

public class Cheese {

	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;
	
	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as paramter
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String n, double p) { // Constructor with 2 parameters
		name = n;
		price = p;
		numCheese++;
	}

	public String getName() { 
		return name;
	}
	
	public double getPrice() {
		
		return price;
	}

	public void setName(String string) {
		 name = string;		
	}

	public void setPrice(double d) {
		price = d;
	}

	public void setAmount(Scanner input) {
		
		amount = input.nextDouble();
			
			do {
				if(amount < 0) {
					System.out.print("Invalid Input. Enter a value >= 0: ");
					break;
				} else if (amount % .5 != 0) {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					break;
				}
			} while(amount < 0 || amount % .5 != 0);
			
	}

	public double getAmount() {
		return amount;
	}
		
}