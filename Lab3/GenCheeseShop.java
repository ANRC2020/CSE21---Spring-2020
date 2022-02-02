import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the number of Cheeses for shop setup: ");
		int MAXCHEESE = in.nextInt();

		int i = 0, c = MAXCHEESE, zero = 0;
		double subtotal = 0, d = 0, total = 0, disc = 0;

		System.out.println(" ");

		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese:");

		String[] names = new String[MAXCHEESE + 1];
		double[] prices = new double[MAXCHEESE + 1];
		double[] amounts = new double[MAXCHEESE + 1];

		if(MAXCHEESE >= 1) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}
		if(MAXCHEESE >= 2) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if(MAXCHEESE >= 3) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}

		if(MAXCHEESE >= 1) {
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}
		if(MAXCHEESE >= 2) {
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}
		if(MAXCHEESE >= 3) {
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
		}

		Random ranGen = new Random(100);

		for (i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");

		}

		System.out.println("");

		c = MAXCHEESE;
		i = 0;

		while(c != 0) {
			System.out.print("Enter the amount of " + names[i] + " in lbs: ");
			amounts[i] = in.nextDouble();
			do {
				if(amounts[i] < 0) {
					System.out.print("Invalid Input. Enter a value >= 0: ");
					amounts[i] = in.nextDouble();
				} else if (amounts[i] % .5 != 0) {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					amounts[i] = in.nextDouble();
				}
				if(amounts[i] > 0) {
					zero = 1;
				}
			} while(amounts[i] < 0 || amounts[i] % .5 != 0);
			i++;
			c--;
		}

		System.out.println("");

		System.out.print("Display the itemized list? (1 for yes) ");
		int display = in.nextInt();
		if(display == 1) {
			if(zero == 1) {
				c = MAXCHEESE;
				i = 0;
				while(c != 0) {
					if((amounts[i] * prices[i]) > 0) {
						System.out.println(amounts[i] + " of " + names[i] + " @ " + prices[i] + " = $" + (amounts[i] * prices[i]));
					}
					i++;
					c--;
				}
			} else {
				System.out.println("No items were purchased");
			}
		}

		System.out.println("");

		c = MAXCHEESE;
		i = 0;
		while(c != 0) {
			subtotal += amounts[i] * prices[i];
			i++;
			c--;
		}

		System.out.println("Original Sub Total:\t\t\t $" + subtotal);
		System.out.println("Specials...");

		if(MAXCHEESE >= 1) {
			if(amounts[0] >= 1) {
				d = amounts[0];
				i = 0;
				while(d != 0) {
					d -= .5;
					i++;
				}

				System.out.println("Humboldt Fog (Buy 1 Get 1 Free):\t-$" + (i/2)*(12.5));
				total += (i/2)*(12.5);
			}
		}
		if(MAXCHEESE >= 2) {
			if(amounts[1] >= 1.5) {
				d = amounts[1];
				i = 0;
				while(d !=0 ) {
					d -= .5;
					i++;
				}

				System.out.println("Red Hawk (Buy 2 Get 1 Free):\t        -$" + (i/3)*(20.25));
				total += ((i/3)*(20.25));
			}
		}
		if(total == 0) {
			System.out.println("None\t\t\t\t        -$0.0"); 
		}					
		System.out.println("New Sub Total: \t\t\t\t $" + (subtotal - total));
		if((subtotal - total) <= 150) {
			disc = 0;
			disc = (subtotal - total) * disc;
			System.out.println("Additional 0% Discount: \t\t-$" + disc); 
		} else if((subtotal - total) > 150 && (subtotal - total) <= 250 ) {
			disc = .10;
			disc = (subtotal - total) * disc;
			System.out.printf("Additional 10%% Discount: \t\t-$%.2f \n", disc); 
		} else if ((subtotal - total) > 250 ) {
			disc = .15;
			disc = (subtotal - total) * disc;
			System.out.printf("Additional 15%% Discount: \t\t-$%.2f \n", disc); 
		}

		System.out.printf("Final Total: \t\t\t\t $%.2f", ((subtotal - total) - disc)); 
	}
}