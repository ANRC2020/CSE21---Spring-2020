import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	public static void intro(String[] names, double[] prices, double[] amounts) {
		int length = names.length;
		
		System.out.println(" ");

		System.out.println("We sell " + length + " kinds of Cheese");

		if(length >= 1) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}
		if(length>= 2) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if(length >= 3) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}

		if(length >= 1) {
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}
		if(length >= 2) {
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}
		if(length >= 3) {
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
		}

		Random ranGen = new Random(100);

		for (int i = 3; i < length; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");

		}

		System.out.println("");
	}
	
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		int c = names.length;
		int i = 0;

		while(c != 0) {
			System.out.print("Enter the amount of " + names[i] + " in lbs: ");
			amounts[i] = sc.nextDouble();
			do {
				if(amounts[i] < 0) {
					System.out.print("Invalid Input. Enter a value >= 0: ");
					amounts[i] = sc.nextDouble();
				} else if (amounts[i] % .5 != 0) {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					amounts[i] = sc.nextDouble();
				}
			} while(amounts[i] < 0 || amounts[i] % .5 != 0);
			i++;
			c--;
		}

		System.out.println("");

	}

	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
			
		int zero = 0;	
		int c = names.length;
		int i = 0;
		while(c != 0) {
			if((amounts[i] * prices[i]) > 0) {
				System.out.print(amounts[i] + " of " + names[i] + " @ " + prices[i] + " = $" );
				System.out.printf("%.2f\n" ,(amounts[i] * prices[i]));
				zero += 1;
			}
			i++;
			c--;
		}
		
		if(zero == 0) {
			System.out.println("No items were purchased.");
		}

		System.out.println("");
		
	}
	
	public static double calcSubTotal(double[] prices, double[] amounts) {
		int c = prices.length;
		int i = 0;
		double subTotal = 0;
		while(c != 0) {
			 subTotal += amounts[i] * prices[i];
			i++;
			c--;
		}

		return subTotal;
		
	}

	public static double[] discountSpecials(double[] amounts, double[] prices){
		double[] disSpecials = new double[amounts.length];

		if(amounts.length >= 1) {
			if(amounts[0] >= 1) {
				double d =  amounts[0];
				int i = 0;
				while(d != 0) {
					d -= .5;
					i++;
				}

				disSpecials[0] += (i/2)*(12.5);
			}
		}
		if(amounts.length >= 2) {
			if(amounts[1] >= 1.5) {
				double d = amounts[1];
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

	public static double printSubTotals(double subTotal, double[] disSpecials) {
		System.out.printf("Original Sub Total:\t\t\t $%.2f\n", subTotal);
		System.out.println("Specials...");
			if(disSpecials.length == 0) {
				System.out.println("None\t\t\t\t        -$0.0"); 			
		} else if(disSpecials.length == 1) {
			if(disSpecials[0] == 0) {
				System.out.println("None\t\t\t\t        -$0.0"); 
			}					
		} else if(disSpecials.length >= 2){
			if(disSpecials[0] + disSpecials[1] == 0) {
				System.out.println("None\t\t\t\t        -$0.0"); 
			}
		}
		if(disSpecials.length > 0) {
			if(disSpecials[0] != 0) {
			System.out.printf("Humboldt Fog (Buy 1 Get 1 Free):\t-$%.2f\n" ,disSpecials[0]);
			} 
		}
		if(disSpecials.length > 1) {
			if(disSpecials[1] != 0) {
			System.out.printf("Red Hawk (Buy 2 Get 1 Free):\t        -$%.2f\n" ,disSpecials[1]);
			}
		}
		
		double newSubTotal = subTotal;
		if(disSpecials.length > 0 && disSpecials.length <= 1) {
			newSubTotal -= disSpecials[0];
			System.out.printf("New Sub Total: \t\t\t\t $%.2f\n", newSubTotal);
			return newSubTotal;
		} 
		if(disSpecials.length >= 2) {
			newSubTotal -= (disSpecials[0] + disSpecials[1]);
			System.out.printf("New Sub Total: \t\t\t\t $%.2f\n", newSubTotal);
			return newSubTotal;
		}
		 
		System.out.printf("New Sub Total: \t\t\t\t $%.2f\n", newSubTotal);
		return newSubTotal;
	}

	public static void printFinalTotal(double newSubTotal) {
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
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		final int MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}