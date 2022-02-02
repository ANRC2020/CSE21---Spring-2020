
public class DecrementableCounter extends Counter {
	
	 public DecrementableCounter (int n) {
		 myCount = n;
	 }
	
	public void Decrement() {
		 if (myCount > 0) {
			 myCount--;
		 }
	}
}
