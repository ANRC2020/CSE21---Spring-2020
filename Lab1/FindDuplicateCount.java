
public class FindDuplicateCount {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2};
		int counter1 = 0, counter2 = 0,   num = 0, i = 0, j = 0, max = arr.length;
		
		while(counter1 <= max) {
			num = 0;
			counter1 = arr[i]; 
			j = i;
			while(j+1 < max) {
				counter2 = arr[j+1];
				if(counter1 == counter2) {
					num++;
				}
				j++;
			}
			if(num == 0) {
				System.out.println("There are no duplicates with value " + counter1 + " beyond index " + i);
			} else if(num > 1) {
				System.out.println("There are " + num + " more occurrences of value " + counter1 + " starting at index " + i);
			} else {
				System.out.println("There is only 1 more occurrence of value " + counter1 + " starting at index " + i);
			}
			if(i == 11) {
				break;
			}
			i++;
		}		
		
	}
}