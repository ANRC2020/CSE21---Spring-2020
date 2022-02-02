import java.util.Scanner;

public class Shop {
	static int func = 0;
	static double price[] = new double[100], discount[] = new double[100], amount[] = new double[100], addDis = 0, addRate = 0, sum = 0, spDis = 0;
	static String name[] = new String[100];
	
	public static void reset(int items){
		func = 0; items = 0; addDis = 0; addRate = 0; sum = 0; spDis = 0;
		for(int i = 0; i < 100; i++) {
			price[i] = -1;
			amount[i] = -1;
			discount[i] = 0;
			name[i] = null;
		}
	}
	
	public static String numSuffix(int i) {
		int rem = i % 10;
		if(i == 11 || i == 12 || i == 13) {
			return "th";
		}
		if(rem == 1) {
			return "st";
		} else if (rem == 2) {
			return "nd";
		} else if (rem == 3) {
			return "rd";
		} else {
			return "th";
		}
	}
	
	public static void setShop(Scanner in, int items) {
		reset(items);
		System.out.println("");
		for(int i = 0; i < items; i++) {
			System.out.print("Enter the name of the " + (i + 1) + numSuffix(i+1) + " product: ");
			name[i] = in.next();
			System.out.print("Enter the per package price of " + name[i] + ": ");
			price[i] = in.nextDouble();
			System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free)\r\n" + "for " + name[i] + ", or 0 if no Special Discount offered: ");
			discount[i] = in.nextDouble();
		}
		System.out.print("\nEnter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
		addDis = in.nextDouble();
		if(addDis > 0) {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			do {
			addRate = in.nextDouble();
			if(addRate > .5 || addRate < 0) {
				System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
			}
			} while(addRate > .5 || addRate <= 0);
		}
		System.out.println("");
	}	
	
	public static boolean amounts(Scanner in, int items) {
		if(price[0] < 0 ) {
			System.out.println("\nShop is not set up yet!\n");			
		} else {
			System.out.println("");
			for(int i = 0; i < items; i++) {
				System.out.print("Enter the number of " + name[i] + " packages to buy: ");
				do{
					amount[i] = in.nextDouble();
					if(amount[i] < 0) {
						System.out.print("Invalid input. Enter a value >= 0: ");
					} else if (amount[i] % .5 != 0) {
						System.out.print("Invalid input. Enter a multiple of 0.5: ");
					}
				}while(amount[i] < 0|| amount[i] % .5 != 0);
			}
			System.out.println("");
		}
		return true;
	}	
	
	public static boolean showlist(Scanner in, int items) {
		double x = 0;
		for(int i = 0; i < items; i++) {
			x += amount[i] * price[i];
		}
		if(price[0] < 0 || amount[0] < 0) {
			if(price[0] < 0) {
				System.out.println("\nShop is not set up yet!\n");
			} else {
				if(x < 0) {
					System.out.println("\nYou have not bought anything!\n");
				}
			}
		} else {
			if(x == 0) {
				System.out.println("\nNo items purchased.\n");
				return true;
			}
			System.out.println("");
			for(int i = 0; i < items; i++) {
				if(amount[i] != 0) {
					System.out.printf((int)amount[i] + " packages of " + name[i] + "@ $" + price[i] + " per pkg = $%.2f \n", (amount[i]*price[i]) );
				}
			}
			System.out.println("");
		}
		return true;
	}
	
	public static double sum(int items) {
		for(int i = 0; i < items; i++) {
			sum += amount[i] * price[i];
		}
		return 0;
	}

	public static int checkout(int items) {
		if(price[0] < 0 || amount[0] < 0) {
			if(price[0] < 0) {
				System.out.println("\nShop is not set up yet!\n");
				return 0;
			} else {
				System.out.println("\nYou have not bought anything!\n");
				return 0;
			}
		} else {
			sum(items);
			System.out.printf("\nOriginal Subtotal:\t\t\t $%.2f \n", sum);
			for(int i = 0; i < items; i++) {
				if(discount[i] > 0) {
						spDis += (((int)amount[i] / (int)(discount[i] + 1)) * price[i]);
				}
			}
			if(spDis > 0) {
				System.out.printf("Special Discounts applied:\t\t-$%.2f \n", spDis);
			} else {
				System.out.println("No Special Discounts applied");
			}
			System.out.printf("New Sub Total:\t\t\t\t $%.2f \n", (sum - spDis));
			sum -= spDis;
			if(addDis < sum && addRate > 0) {			
				System.out.println("Additional " + (100 * addRate) + "% Discount: \t\t-$" + (sum * addRate)); 
				sum -= (sum * addRate);
			} else {
				System.out.println("You did not qualify for an Additional Discount");
			}
			System.out.printf("Final Sub Total: \t\t\t $%.2f \n", sum);
			System.out.println("\nThanks for coming!");
			return 1;
		}
	}	
	
	public static void run(Scanner in, int items, int done) {
		reset(items);
		while(done == 0) {
			System.out.print("This program supports 4 functions:\n 1. Setup Shop\n 2. Buy\n 3. List Items\n 4. Checkout"
					+ "\nPlease choose the function you want: ");
			func = in.nextInt();
			if(func == 1) {
				System.out.print("Please enter the number of items to setup shop: ");
				items = in.nextInt();
				setShop(in, items);
			} else if (func == 2) {
				amounts(in, items);
			} else if (func == 3) {
				showlist(in, items);
			} else if (func == 4) {
				done = checkout(items);
			}
		}
		System.out.println("-------------------------------------------------");
		System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
		int input = in.nextInt();
		System.out.println("-------------------------------------------------");
		if(input == 1) {
			System.out.println("");
			items = 0;
			done = 0;
			run(in, items, done);
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int items = 0;
		int done = 0;
		run(in, items, done);
	}
}