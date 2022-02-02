

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		testModNCounter();
		
		testModNCounter2();

		testDecrementCounter();

		testSeasonCounter();
	}

	private static void testSeasonCounter() {
		System.out.println("-- testing Season Counter");
		SeasonCounter c = new SeasonCounter();
		System.out.println(c.toString());
		c.increment();
		System.out.println(c.toString());
		c.increment();
		System.out.println(c.toString());
		c.increment();
		
	}

	private static void testDecrementCounter() {
		System.out.println("-- testing decrement Counter");
		DecrementableCounter c = new DecrementableCounter(3);
		System.out.println(c.value());
		c.Decrement();
		System.out.println(c.value());
		c.Decrement();
		System.out.println(c.value());
		c.Decrement();
		System.out.println(c.value());
		c.Decrement();
		System.out.println(c.value());
		c.Decrement();
	}

	private static void testModNCounter2() {
		System.out.println("-- testing Counter2");
		ModNCounter2 c = new ModNCounter2(2);
		System.out.println(c.value());
		c.increment();
		System.out.println(c.value());
		c.increment();
		System.out.println(c.value());
		c.increment();
	}

	public static void testModNCounter() {
		ModNCounter c = new ModNCounter(2);//Initialized "n" value
		System.out.println(c.value());
		c.increment();
		System.out.println(c.value());
		c.increment();
		System.out.println(c.value());
		c.increment();
	}

	public static void testCounter() {
		System.out.println("-- Testing Counter");

		Counter c = new Counter();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());

	}
	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- Testing 7 statements");
		c.increment();
		c.increment();
		c.increment();
		c.reset();
		c.increment();
		c.increment();
		c.increment();

		System.out.println("Current value: " + c.value());
	}

}