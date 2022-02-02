import java.util.*;

public class Shoparr {

	private Cheese[] cheese; 
	
	public Shoparr() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		init(in.nextInt());
		System.out.println();
	}
	
	private void init(int max) {
		cheese = new Cheese[max]; 
		
		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);
			
			if (max > 1) {
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);
			
				if (max > 2) {
					cheese[2] = new Cheese("Teleme", 17.25);
					if(max >= 3) {
						Random ranGen = new Random(100);

						for (int i = 3; i < max; i++) {
							cheese[i] = new Cheese();
							cheese[i].setName("Cheese Type " + (char)('A' + i));  
							cheese[i].setPrice(ranGen.nextInt(1000)/100.0);  
						}
					}
				}
			}
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////
	private void intro(Scanner input) {
		System.out.println("We sell " + cheese.length + " kinds of Cheese (in 0.5 lb packages)");
		int i = 0;
		while(i < cheese.length) {
			System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound");
			i++;
		}
		System.out.println("");
		i = 0;
		while(i < cheese.length) {
			System.out.print("Enter the amount of " + cheese[i].getName() + " in lb: ");
			cheese[i].setAmount(input);
			while(cheese[i].getAmount() < 0 || cheese[i].getAmount() % .5 != 0) {
				cheese[i].setAmount(input);
			}
			i++;
		}
		
	}

	private void itemizedList(){
		double amt = 0, price = 0, subtotal = 0;		
		for(int i = 0; i < cheese.length; i++) {
			amt = cheese[i].getAmount();
			price = cheese[i].getPrice();
			subtotal += amt * price;
		}
		if(subtotal <= 0) {
			System.out.println("No items purchased.");
		} else {
			for(int i = 0; i < cheese.length; i++) {
				amt = cheese[i].getAmount();
				price = cheese[i].getPrice();
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $" + price + " = $" + (amt * price));
			}
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////
	private double calcSubTotal() {
		double subTotal = 0;
		for(int i = 0; i < cheese.length; i++) {
			subTotal += cheese[i].getAmount() * cheese[i].getPrice();
		}

		return subTotal;
	}
	
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};
		
		if(cheese.length ==  0) {
			return disSpecials;
		} else if (cheese.length ==  1) {
			double hfAmt = cheese[0].getAmount();
			
			if (hfAmt > 0) {
				if(hfAmt >= 1) {
					double d =  hfAmt;
					int i = 0;
					while(d != 0) {
						d -= .5;
						i++;
					}

					disSpecials[0] += (i/2)*(12.5);
				}
			}
			
			return disSpecials;
		} else if (cheese.length >=  2) {
			double hfAmt = cheese[0].getAmount(), rhAmt = cheese[1].getAmount();
			
			if (hfAmt > 0) {
				if(hfAmt >= 1) {
					double d =  hfAmt;
					int i = 0;
					while(d != 0) {
						d -= .5;
						i++;
					}

					disSpecials[0] += (i/2)*(12.5);
				}
			}
			
			if(rhAmt > 0) {
				if(rhAmt >= 1.5) {
					double d = rhAmt;
					int i = 0;
					while(d !=0 ) {
						d -= .5;
						i++;
					}
					
					disSpecials[1] += ((i/3)*(20.25));
				}
			}
			
			return disSpecials;
		}		
		return disSpecials;
	}

	private double printSubTotals(double subTotal, double[] disSpecials) {
		double discount = disSpecials[0]  + disSpecials[1];
		System.out.println("Original Sub Total:   \t\t\t $" + subTotal + "\n");
		System.out.println("Specials.... ");
		if(disSpecials.length == 0) {
			System.out.println("None");
		} else if(disSpecials.length == 1) {
			System.out.println(" Humboldt Fog (Buy 1 Get 1 Free): -$" + disSpecials[0]);
		} else if(disSpecials.length >= 2) {
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + disSpecials[0]);
			System.out.println("Red Hawk (Buy 2 Get 1 Free): -$" + disSpecials[1]);
		}
		double nsub = subTotal -  discount;
		System.out.println("New Subtotal:   \t\t\t $" + nsub);
		return nsub;
	}

	private void printFinalTotal(double newSubTotal) {
		if(newSubTotal <= 150) {
			double disc = 0;
			disc = (newSubTotal) * disc;
			System.out.println("Additional 0% Discount: \t\t-$" + disc); 
			System.out.printf("Final Total: \t\t\t\t $%.2f", (newSubTotal - disc)); 
		} else if(newSubTotal > 150 && newSubTotal <= 250 ) {
			double disc = .10;
			disc = newSubTotal * disc;
			System.out.printf("Additional 10%% Discount: \t\t-$%.2f \n", disc); 
			System.out.printf("Final Total: \t\t\t\t $%.2f", (newSubTotal - disc)); 
		} else if (newSubTotal > 250 ) {
			double disc = .25;
			disc = newSubTotal * disc;
			System.out.printf("Additional 25%% Discount: \t\t-$%.2f \n", disc); 
			System.out.printf("Final Total: \t\t\t\t $%.2f", (newSubTotal - disc));
		}		
	}

	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $0 = $" + 0);
		System.out.println("Total Price: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();
		
		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int y = input.nextInt();
		if (y == 1) {
			itemizedList();	
		}
		
		int free = (new Random()).nextInt(100);
		System.out.println("");
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}
		
		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1) {
			Shoparr();
			run();
		} else {
			System.out.println("Thanks for coming!");
		}
	}

	private void Shoparr() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		init(in.nextInt());
		System.out.println();
	}
}