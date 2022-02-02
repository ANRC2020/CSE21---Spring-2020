
public class Dummy {
	
	// Constructor 1
	public Dummy() {
		System.out.println("(1) No arguments constructor");
	}

	// Constructor 2
	public Dummy(int param1) {
		System.out.println("(2) Int argument constructor");
	}

	// Constructor 3
	public Dummy(double param1) {
		System.out.println("(3) Double argument constructor");
	}

	// Constructor 4
	public Dummy(int[] param1) {
		System.out.println("(4) Int[] argument constructor");
	}

	// Constructor 5
	public Dummy(double[] param1) {
		System.out.println("(5) Double[] argument constructor");
	}

	// Constructor 6
	public Dummy(Dummy param1) {
		System.out.println("(6) Dummy argument constructor");
	}
	
	public Dummy(double[] darr, int[] iarr) {
		System.out.println("(7) Double[] argument and double arguement constructor");
	}

	public Dummy(double d, int[] iarr) {
		System.out.println("(8) Double argument and double[] arguement constructor");
	}
	
	public Dummy(int[] iarr, double d) {
		System.out.println("(9) Double[] argument and double arguement constructor");
	}

	public Dummy(Dummy dummy, double d) {
		System.out.println("(10) Dummy argument and double arguement constructor");
	}	

	public Dummy(Dummy dummy, Dummy dummy2) {
		System.out.println("(11) Dummy argument and dummy arguement constructor");
	}

	public void display() {
		System.out.println("(1) Display");
	}
	
	public void display(int param1) {
		System.out.println("(2) Display");
	}
	
	public void display(double param1) {
		System.out.println("(3) Display");
	}
	
	public void display(int[] param1) {
		System.out.println("(4) Display");
	}
	
	public void display(double[] param1) {
		System.out.println("(5) Display");
	}
	
	public void display(Dummy param1) {
		System.out.println("(6) Display");
	}
	
	public void display(double[] darr, int[] iarr) {
		System.out.println("(7) Display");
	}
	
	public void display(double d, int[] iarr) {
		System.out.println("(8) Display");
	}
	
	public void display(int[] iarr, double d) {
		System.out.println("(9) Display");
	}
	
	public void display(Dummy dummy, double d) {
		System.out.println("(10) Display");
	}
	
	public void display(Dummy dummy, Dummy dummy2) {
		System.out.println("(11) Display");
	}
}