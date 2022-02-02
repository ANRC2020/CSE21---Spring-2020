import java.util.Scanner;

public class CheeseShop {
	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in);
		
		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):\r\n" + "Humboldt Fog: $25.0 per pound\r\n" + "Red Hawk: $40.5 per pound\r\n" + "Teleme: $17.25 per pound\r\n");
		double humbolt_fog, red_hawk, telme,sub_total, c=0, total = 0, humbolt_price = 25.0, red_price = 40.5, telme_price = 17.25;
		int display, i=0;
		
		System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		humbolt_fog = in.nextDouble();
		do{
			if(humbolt_fog < 0) {
				System.out.print("Invalid Input. Enter a value >= 0: ");
				humbolt_fog = in.nextDouble();
			} else if (humbolt_fog % .5 != 0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				humbolt_fog = in.nextDouble();
			}
		} while(humbolt_fog < 0 || humbolt_fog %.5 != 0);	
		
		System.out.print("Enter the amount of Red Hawk in lbs: ");
		red_hawk = in.nextDouble();
		do {
			if(red_hawk < 0) {
				System.out.print("Invalid Input. Enter a value >= 0: ");
				red_hawk = in.nextDouble();
			} else if (red_hawk % .5 != 0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				red_hawk = in.nextDouble();
			}
		} while(red_hawk < 0 || red_hawk %.5 != 0);
		
		System.out.print("Enter the amount of Teleme in lbs: ");
		telme = in.nextDouble();
		do {
			if(telme < 0) {
				System.out.print("Invalid Input. Enter a value >= 0: ");
				telme = in.nextDouble();
			} else if (telme % .5 != 0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				telme = in.nextDouble();
			}
		} while(telme < 0 || telme %.5 != 0);
		
		System.out.println("");
		
		System.out.print("Display the itemized list? (1 for yes) ");
		display = in.nextInt();
		if(display == 1) {
			if(humbolt_fog == 0 && red_hawk == 0 && telme == 0) {
				System.out.println("No items were purchased.");
			}
			if(humbolt_fog > 0) {
			System.out.println(humbolt_fog + " lb of Humboldt Fog @ $25.0 = $" + (25.0 * humbolt_fog));
			}
			if(red_hawk > 0) {
			System.out.println(red_hawk + " lb of Red Hawk @ $40.5 = $" + (40.5 * red_hawk));
			}
			if(telme > 0) {
			System.out.println(telme + " lb of Teleme @ $17.25 = $" + (17.25 * telme));
			}
		} 
		
		System.out.println("");
		
		sub_total = (25.0 * humbolt_fog) + (40.5 * red_hawk) + (17.25 * telme);
		System.out.println("Sub total: \t\t\t  $" + sub_total);
		System.out.println("Discounts...");
		if(humbolt_fog >= 1) {
			c = humbolt_fog;
			while(c != 0) {
				c -= .5;
				i++;
			}
			
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + (i/2)*(12.5));
			total += (i/2)*(12.5);
		}
		if(red_hawk >= 1.5) {
			c = red_hawk;
			i = 0;
			while(c !=0 ) {
				c -= .5;
				i++;
			}
			
			System.out.println("Red Hawk (Buy 2 Get 1 Free):  \t -$" + (i/3)*(20.25));
			total += ((i/3)*(20.25));
		}
		if(humbolt_fog < 1 && red_hawk <= 1.5) {
			System.out.println("None\t\t\t\t -$0.0"); 
		}
		
		System.out.println("Final total:\t\t\t  $" + (sub_total - total));
		}
	}