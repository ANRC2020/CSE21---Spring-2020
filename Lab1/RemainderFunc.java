import java.util.Scanner;

public class RemainderFunc {

	public static void main(String[] args) {
		
		int maxnum;
		int divisor = 0;
		int a;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter the max number: ");
		maxnum = in.nextInt();
		while(maxnum <= 0) {
			System.out.print("Invalid input. Please enter a valid max number (>= 0): ");
			maxnum = in.nextInt();
		}
		System.out.print("Please enter the divisor number: ");
		divisor = in.nextInt();
		while(divisor <= 0) {
			System.out.print("Invalid input. Please enter a valid divisor (>= 0): ");
			divisor = in.nextInt();
		}
		System.out.println("Multiples of " + divisor + " between 1 and " + maxnum +  "(inclusive) are: ");
		for(a = 1; a <= maxnum; a++) {
			if(a % divisor == 0) {
				System.out.println(a);
			}
		}
	}

}
