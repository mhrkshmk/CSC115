// Name: Mehrkish Makouei
// Student number: V00986351

/*
 * A1Exercises
 *
 * Rules: 
 *  - DO NOT use builtin java Arrays methods
 */
public class A1Exercises {
	
	/*
	 * isFactor
	 * Purpose: Determine if x can be evenly divided by y
	 * Parameters int x, int y
	 * Returns: true if x can be evenly divided by y, false otherwise
	 */
	public static boolean isFactor(int x, int y) {
		if (x % y == 0) {
			return true;
		} else {
			return false;
		}
	}	
	
	/*
	 * calcPower
	 * Purpose: Calculate the value of base^exp
	 * Parameters: int base - the base value
	 *             int exp - the exponent value
	 * Returns: int - the value of base^exp
	 * Pre-conditions: base > 0, exp >= 0
	 */
	public static int calcPower(int base, int exp) {
		int result = 1;
		for (int i = 0; i < exp; i++) {
			result *= base;
		}
		return result;
	}
	
	/*
	 * numFactors
	 * Purpose: Determine the number of factors of n
	 * Parameters: int n
	 * Returns: int - the number of factors of n
	 * Pre-conditions: n > 0
	 */
	public static int numFactors(int n) {
		int result = 0;
		// TODO: add code to finish the method implementation
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				result++;
			}
		}
		return result;
	}
	
	/*
	 * isPrime
	 * Purpose: determine if n is a prime number
	 * Paramaters: int n
	 * Returns: boolean - true if n is prime, false otherwise
	 * Pre-conditions: n > 1
	 */
	// TODO: write the isPrime method here
	public static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return (n != 1);
	}
	
	/*
	 * greatestCommonDenominator
	 * Purpose: determine the largest integer that divides x and y
	 * Parameters: int x, int y
	 * Returns: int the largest integer that divides x and y
	 * Pre-conditions: x, y > 0
	 */
	// TODO: write the greatestCommonDenominator method here
	public static int greatestCommonDenominator(int x, int y) {
		if (y == 0) {
			return x;
		}
		return greatestCommonDenominator(y, x % y);
	}
	
	/*
	 * printArray
	 * Purpose: prints all values in the array to the console
	 *          Example format:  {1,2,3,4}
	 * Parameters: int[] - an array of integers
	 * Returns: void - nothing
	 */
	public static void printArray (int[] array) {
		System.out.print("{");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]);
			if(i<array.length-1) {
				System.out.print(",");
			}	
		}
		System.out.println("}");
	}
	
	/*
	 * sumArray
  	 * Purpose: computes the sum of all values in the given array
 	 * Parameters: int[] array - the array of integers
	 * Returns: int - sum of all values in the array
	 * Pre-conditions: the array is not null (but could be empty)
	 */
	// TODO: write the sumArray method here
	public static int sumArray(int[] arr) {
		int n = arr.length, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	/*
	 * contains
	 * Purpose: determines whether the array contains x
	 * Parameters: int[] array - array of integers to search through
	 *             int x - the value to search for
	 * Returns: boolean - true if value is found, false otherwise
	 * Pre-conditions: the array is not null (but could be empty)
	 */
	// TODO: write the contains method here
	public static boolean contains(int[] arr, int x) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (x == arr[i]) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * countMatches
	 * Purpose: Determines the number of occurences of x in the given array
	 * Parameters: int[] array - array of integers to search through
	 *             int x - the value to search for
	 * Returns: int - the number of times x is found in the array
	 * Pre-conditions: the array is not null (but could be empty)
	 */
	// TODO: write the countMatches method here */
	public static int countMatches(int[] arr, int x) {
		int n = arr.length, cnt = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				cnt++;
			}
		}
		return cnt;
	}
	
}