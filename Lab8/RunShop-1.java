import java.util.Scanner;

public class RunShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Shoparr shoparr = new Shoparr();
		shoparr.run();
		System.out.println("Ran with Cheese Total: " + Cheese.numCheese);
		input.close();
	}
	
}