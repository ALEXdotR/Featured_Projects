import java.util.Scanner;
public class Q1_55695318 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Input an integer: ");
		int input1 = reader.nextInt();
		
		System.out.print("Input a string in digits: ");
		String input2 = reader.next();
		
		// Input is an integer
		MyInteger number = new MyInteger(input1);
		System.out.println("Is " + input1 + " a prime number? " + number.isPrime());
				
		// Input is a string
		MyInteger numberString = new  MyInteger(MyInteger.convert(input2));
		System.out.print("Is " + input2 + " a prime number? " + numberString.isPrime());
	}
	
	
}
class MyInteger {
	int x;
		
	// constructor
	MyInteger(int x) {
		this.x = x;
	}
		
	// check whether x is a prime number
	public boolean isPrime() {
		int temp = 0;
		for (int i = 2; i < x; i++) {
			if ((x % i) == 0) {
				temp++;
			}
		}
		if (temp > 0) {
			return false;
		} else {
			return true;
		}
	}

	// convert string into integer
	public static int convert(String nstring) {
		int x = 0;
		for (int i=0; i < nstring.length(); i++) {
			x *= 10;
			x += nstring.charAt(i)-'0';
		}
		return x;
	}
}