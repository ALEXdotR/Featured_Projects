import java.util.Scanner;
public class Q3_55695318 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		// read the value of N into the variable n
		System.out.print("Input a value for N: ");
		int n = reader.nextInt();
		
		int count = 0; 	// keep track of the number of twin primes being found
		int num = 13;	// start from 13
		
		// MODIFY and COMPLETE this part to print the first N twin primes
		do {
			if (isPrime(num)==true && isPrime(reverse(num))==true) {
				count++;
				System.out.println("(" + num + "," + reverse(num) + ")");
			}
			num++;
		} while (count < n);
		
	}
		
	// NO NEED to modify
	public static boolean isPrime(int number) {
		boolean flag = true;
		
		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}
		
		return true;
	}
	
	// NO NEED to modify
	public static int reverse(int number) {
		int result = 0;
		
		while (number != 0) {
			result *= 10;
			result += number%10;
			number /= 10;
		}
		
		return result;

	}

}