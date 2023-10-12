class LoopExercises {

	public static void main (String[] args) {

		// Q1. Complete the implementation of getHighest
		testGetHighest();

		// Q2. Write and test the method factorial
		testFactorial();

		// Q3. Write and test the method sumToN
		testSumToN();

	}
	
	public static void testGetHighest() {
		int result = 0;
		
		result = getHighest(1, 2, 3);
		// What should the result be?
		System.out.println("called getHighest(1, 2, 3)");
		System.out.println("expected: 3, got "+result);
		System.out.println();
		
		result = getHighest(5, 4, 3);
		// What should the result be?
		System.out.println("called getHighest(5, 4, 3)");
		System.out.println("expected: 5, got "+result);
		System.out.println();
		
		result = getHighest(0, 2, 1);
		// What should the result be?
		System.out.println("called getHighest(0, 2, 1)");
		System.out.println("expected: 2, got "+result);
		System.out.println();
		
		result = getHighest(1, 1, 1);
		// What should the result be?
		System.out.println("called getHighest(1, 1, 1)");
		System.out.println("expected: 1, got "+result);
		System.out.println();
	}
	
	/*
	 * Purpose: return the maximum of the three given values
	 * Parameters: int, int, int - the three values to compare
	 * Returns: int - integer with the highest value 
	 */
	public static int getHighest(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		} else if (b >= c) {
			return b;
		} else {
		return c;
		}
	}


	
	public static void testFactorial() {
		// Write tests here
		int result = 0;
		int expected = 0;
		
		result = factorial(3);
		expected = 3*2*1;
		System.out.println("expected: "+expected);
		System.out.println("result returned: "+result);
		
		result = factorial(6);
		expected = 6*5*4*3*2*1;
		System.out.println("expected: "+expected);
		System.out.println("result returned: "+result);
	}

	/*
	 * factorial
	 * Purpose: Calculate n factorial (n!)
	 * Parameters: int - the value n
	 * Precondition: n >= 0
	 * Returns: int - n factorial
	 */
	 
	// Write the factorial method here
	
	public static int factorial(int n){
		int result = 1;
		for (int i = 1; i<=n; i++) {
			result *= i;
		}
		return result;
	}
	
	


	public static void testSumToN() {
		// Write tests here
		int result = sumToN(2);
		System.out.println("called sumToN(2)");
		System.out.println("expected: 3, got "+result);
	}
	
	/*
	 * sumToN
	 * Purpose: sum the numbers from 1 to n
	 * Parameters: int - the value n
	 * Precondition: n > 0
	 * Returns: int - the sum 
	 */
	 
	 // Write the sumToN method here
	 public static int sumToN(int n) {
		 int result = 0;
		 for (int i = 0; i<=n; i++) {
			 result += i;
		 }
		 return result;
	 }
	
	


}
