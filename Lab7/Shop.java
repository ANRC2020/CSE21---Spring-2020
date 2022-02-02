import java.util.Random;
import java.util.Scanner;

public class Shop {

	Cheese HFog, RHawk, Teleme;

	public Shop() {
		HFog = new Cheese();
		HFog.setName("Humboldt Fog");
		HFog.setPrice(25.00);

		RHawk = new Cheese("Red Hawk");
		RHawk.setPrice(40.50);

		Teleme = new Cheese("Teleme", 17.25);
	}
	
	private void intro(Scanner input) {
		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println(HFog.getName() + ": $" + HFog.getPrice() + " per pound");
		System.out.println(RHawk.getName() + ": $" + RHawk.getPrice() + " per pound");
		System.out.println(Teleme.getName() + ": $" + Teleme.getPrice() + " per pound");
		
		System.out.print("\nEnter the amount of " + HFog.getName() + " in lbs: ");
		HFog.setAmount(input);
		while(HFog.getAmount() < 0 || HFog.getAmount() % .5 != 0) {
			HFog.setAmount(input);
		}
		System.out.print("\nEnter the amount of " + RHawk.getName() + " in lbs: ");
		RHawk.setAmount(input);
		while(RHawk.getAmount() < 0 || RHawk.getAmount() % .5 != 0) {
			RHawk.setAmount(input);
		}
		System.out.print("\nEnter the amount of " + Teleme.getName() + " in lbs: ");
		Teleme.setAmount(input);
		while(Teleme.getAmount() < 0 || Teleme.getAmount() % .5 != 0) {
			Teleme.setAmount(input);
		}
	}

	private void itemizedList(){
		double amt = 0, price = 0;
		if ((HFog.getAmount() + RHawk.getAmount() + Teleme.getAmount()) == 0)
			System.out.println("No items were purchased.");
		else {
			if ((amt = HFog.getAmount()) > 0) {
				price = HFog.getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, HFog.getName(), price, price*amt);
			}
			if ((amt = RHawk.getAmount()) > 0) {
				price = RHawk.getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, RHawk.getName(), price, price*amt);
			}
			if ((amt = Teleme.getAmount()) > 0) {
				price = Teleme.getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, Teleme.getName(), price, price*amt);
			}
		}
	}
	
	private double calcSubTotal() {
		double subTotal = 0;
		subTotal += HFog.getAmount() * HFog.getPrice();
		subTotal += RHawk.getAmount() * RHawk.getPrice();
		subTotal += Teleme.getAmount() * Teleme.getPrice();
		
		return subTotal;
	}

	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};
		
		double hfAmt = HFog.getAmount(), rhAmt = RHawk.getAmount();
		
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
	
	private double printSubTotals(double subTotal, double[] disSpecials) {
		double discount = disSpecials[0]  + disSpecials[1];
		System.out.println("Original Sub Total:   \t\t\t $" + subTotal);
		System.out.println("Discounts based on specials:   \t\t-$" + discount);
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
		if ((amt = HFog.getAmount()) > 0) 
			System.out.println(amt + " lb of Humboldt Fog @ $0 = $" + 0);
		if ((amt = RHawk.getAmount()) > 0) 
			System.out.println(amt + " lb of Red Hawk @ $0 = $" + 0);
		if ((amt = Teleme.getAmount()) > 0) 
			System.out.println(amt + " lb of Teleme @ $0 = $" + 0);
		System.out.println("Total: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();
		
		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	
		System.out.println("");
		int free = (new Random()).nextInt(100);
		System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}
		
		System.out.print("\n\n");
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
	
}
