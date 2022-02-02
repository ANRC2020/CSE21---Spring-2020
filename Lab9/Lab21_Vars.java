import java.util.*;

public class Lab21_Vars {

	public static void main(String[] args) {

		int i = 0, j = 0;
		//int i, j; no values are assigned to 1 or j
		int var0, var1;
		
		// Fix 1: Correctly typecast 5.0 to an int so it can assigned to var3.
		int var2 = 0, var3 = (int)5.0;
		//var3 = 5.0; Added an (int) cast to change 5.0 from a double type to an integer
		
		// Fix 2: Correctly declare a variable as an array.
		int [] arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//int arri0 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; Missing "[]" in declaration
		
		double[] arrd0 = {0.0, 1.0, 2.0, 3.0, 4.0};
		
		// Fix 3: What's wrong with temp? Fix it.
		if (i < j) {
			int temp = 0;
			System.out.println("Temp is " + temp);
		} else {
			int temp = 1;
			//temp = 1; error because "temp" was not declared as an int inside this scope
			System.out.println("Temp is " + temp);
		}
		
		// Fix 4: Correctly calculate square of sums and print it as total.
		int total = 0;
		int k = 0;
		for (k = 0; k < 10; k++) {//int i = 0; changed "i" to "k" top avoid duplicate variable error
			//int total = 0; "total" must be viewable outside of the loop to be accessed later
			total += k*k;
		}
		System.out.println("i value is " + k);
		System.out.println("Total is " + total);
		
		// Fix 5: Figure out the logical error in lines 36-42, and correct it.
		//Created Cheese.java class
		Cheese jack;
		Cheese monterey = new Cheese("Monterey");
		jack = monterey;
		System.out.println("Monterey name is " + monterey.getName());
		jack.setName("Jack");
		System.out.println("Jack name is " + jack.getName());
		System.out.println("Monterey name is still " + monterey.getName());
	
		// Fix 6: Make the following code shorter by combining redundant 
		//        (unnecessary/duplicate) statements
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number: ");
		var2 = input.nextInt();
		System.out.print("Enter second number: ");
		var3 = input.nextInt();
		if(var2 > var3)
			System.out.println("First is less than or equal");
		else if (var2 < var3)
			System.out.println("Second is greater than");
		else 
			System.out.println("Numbers are equal");
		/*if (input.nextInt() > var3) {
			System.out.print("Enter second number: ");
			int num2 = input.nextInt();
			System.out.println("First is greater");
			if (num2 < var3)
				System.out.println("Second is Less than");
			else
				System.out.println("Second is Greater or equal");
		} else {
			System.out.print("Enter second number: ");
			int num2 = input.nextInt();
			System.out.println("First is Less than or equal");
			if (num2 < var3)
				System.out.println("Second is Less than");
			else
				System.out.println("Second is Greater or equal");
		} */
		printfirstnum(var2);
		}
		
		// Fix 7: Print out the first number entered by the user
		//        (Hint - You will need to modify the above code)
		public static void printfirstnum(int var2) {
			System.out.println(var2);
		}
		
	}