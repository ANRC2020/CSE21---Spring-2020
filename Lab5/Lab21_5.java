public class Lab21_5 {

	public static void init(long[] arr, long[] arr1 ,long[] arr2, long[] arr3,long[] arr4, long[] arr_sum, long[] num) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
			arr1[i] = 0;
			arr2[i] = 0;
			arr3[i] = 0;
			num[i] = 0;
			arr_sum[i] = 0;
		}
	}

	public static long sumAll(int max) {
		long subTotal = 0;
		for (int i = 1; i <= max; i++) {
			subTotal += i;
			System.out.println("sumAll " + i + " value " + subTotal);
		}
		return subTotal;
	}
	
	public static long sumAll(long[] arr, int max) {
		for (int i = 1; i <= max ; i++) {
			if (arr[i] == 0) {
				arr[i] = arr[i-1] + i;	
				System.out.println("sumAll[" + i + "] value " + arr[i]);
			}
		}
		return arr[max];

	}
	//-----------------------------------------------------------------------------------------------
	public static long squareSum(int max) {
		long subTotal = 0;
		for (int i = 1; i <= max; i++) {
			subTotal += i * i;
			System.out.println("SquareSum " + i + " value " + subTotal);
		}
		return subTotal;
	}
	
	public static long squareSum(long[] arr1, int max) {
			for (int i = 1; i <= max; i++) {
				if (arr1[i] == 0) {
					arr1[i] = arr1[i-1] + (i * i);
					System.out.println("SquareSum[" + i + "] value " + arr1[i]);
				}
			}
		
		return arr1[max];
	}
	//-----------------------------------------------------------------------------------------------
	public static long fib(int max, long[] arr_sum) {
		long subTotal = 0;
		int j = 0;
		arr_sum[0] = 0;
		arr_sum[1] = 1;
		for (int i = 2; i <= max; i++) {
			arr_sum[j + 2] = arr_sum[j] + arr_sum[j + 1] ;
			subTotal = arr_sum[j] + arr_sum[j + 1] ; 
			System.out.println("Fibonacci " + i + " value " + subTotal);
			j++;
		}
		return subTotal;
	}
	
	public static long fib(long[] arr_sum, int max) {
		int j = 0;
		long c = arr_sum[max];
		for (int i = 0; i < arr_sum.length; i++) {
			arr_sum[i] = 0;
		}
		arr_sum[0] = 0;
		arr_sum[1] = 1;
		if(c < max) {
			for (int i = 2; i <= max; i++) {
				if (arr_sum[i] == 0) {
					arr_sum[j + 2] = arr_sum[j] + arr_sum[j + 1] ;
					System.out.println("Fibonacci[" + i + "] value " + arr_sum[i]);
					j++;
				}
			}	
		} else {
			for (int i = 2; i <= max; i++) {
				if (arr_sum[i] != 0) {
					arr_sum[j + 2] = arr_sum[j] + arr_sum[j + 1] ;
					System.out.println("Fibonacci[" + i + "] value " + arr_sum[i]);
					j++;
				}
			}
		}
		arr_sum[max] = max;
	return arr_sum[max];
	}
	//-----------------------------------------------------------------------------------------------
	public static long factorial( int max, long[] num) {
		long factorial = 1;
		for(int i = 0; i != max + 1; i++) {
			num[i] = i;
		}
		for(int i = 2; i < max + 1; i++) {
			factorial = factorial * num[i];
			System.out.println("Factorial " + i + " value " + factorial);
		}
		return factorial;
	}
	
	public static long factorial(long[] arr4, int max) {
		long factorial = 1;
		long c = arr4[max];
		for(int i = 0; i != max + 1; i++) {
			arr4[i] = i;
		}
		if(c < max) {
			for(int i = 2; i < max + 1; i++) {
				factorial = factorial * arr4[i];
				System.out.println("Factorial[" + i + "] value " + factorial);
			}
		} else {
			for(int i = 2; i < max + 1; i++) {
				factorial = factorial * arr4[i];
				}
		}
		arr4[max] = max;
		return factorial;
	}
	//-----------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		final int MAXSIZE = 100;
		long[] arr = new long[MAXSIZE];
		long[] arr1 = new long[MAXSIZE];
		long[] arr2 = new long[MAXSIZE];
		long[] arr3 = new long[MAXSIZE];
		long[] arr4 = new long[MAXSIZE];
		long[] arr_sum = new long[MAXSIZE];
		long[] num = new long[MAXSIZE];
		
		System.out.println("sumAll output for 5 is " + sumAll(5));
		System.out.println("sumAll output for 10 is " + sumAll(10));
		System.out.println("sumAll output for 20 is " + sumAll(20));
		System.out.println("sumAll output for 15 is " + sumAll(15));
		System.out.println();

		init(arr, arr1, arr2, arr3, arr4, arr_sum, num);
		System.out.println("sumAll output for 5 is " + sumAll(arr, 5));
		System.out.println("sumAll output for 10 is " + sumAll(arr, 10));
		System.out.println("sumAll output for 20 is " + sumAll(arr, 20));
		System.out.println("sumAll output for 15 is " + sumAll(arr, 15));
		System.out.println();

		
		System.out.println("squareSum output for 5 is " + squareSum(5));
		System.out.println("squareSum output for 10 is " + squareSum(10));
		System.out.println("squareSum output for 20 is " + squareSum(20));
		System.out.println("squareSum output for 15 is " + squareSum(15));
		System.out.println();

		init(arr, arr1, arr2, arr3, arr4, arr_sum, num);
		System.out.println("squareSum output for 5 is " + squareSum(arr1, 5));
		System.out.println("squareSum output for 10 is " + squareSum(arr1, 10));
		System.out.println("squareSum output for 20 is " + squareSum(arr1, 20));
		System.out.println("squareSum output for 15 is " + squareSum(arr1, 15));
		System.out.println();

		System.out.println("Fibonacci Number 5 is " + fib(5, arr_sum));
		System.out.println("Fibonacci Number 10 is " + fib(10, arr_sum));
		System.out.println("Fibonacci Number 20 is " + fib(20, arr_sum));
		System.out.println("Fibonacci Number 15 is " + fib(15, arr_sum));
		System.out.println();

		init(arr, arr1, arr2, arr3, arr4, arr_sum, num);
		System.out.println("Fibonacci Number 5 is " + fib(arr3, 5));
		System.out.println("Fibonacci Number 10 is " + fib(arr3, 10));
		System.out.println("Fibonacci Number 20 is " + fib(arr3, 20));
		System.out.println("Fibonacci Number 15 is " + fib(arr3, 15));
		System.out.println();

		System.out.println("Factorial of 5 is " + factorial(5, num));
		System.out.println("Factorial of 10 is " + factorial(10, num));
		System.out.println("Factorial of 20 is " + factorial(20, num));
		System.out.println("Factorial of 15 is " + factorial(15, num));
		System.out.println();

		init(arr, arr1, arr2, arr3, arr4, arr_sum, num);
		System.out.println("Factorial of 5 is " + factorial(arr4, 5));
		System.out.println("Factorial of 10 is " + factorial(arr4, 10));
		System.out.println("Factorial of 20 is " + factorial(arr4, 20));
		System.out.println("Factorial of 15 is " + factorial(arr4, 15));
		
	} 

}