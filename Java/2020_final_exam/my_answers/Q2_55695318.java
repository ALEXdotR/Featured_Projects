import java.util.Scanner;
public class Q2_55695318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		boolean flag = false;
		int[] inputArray = new int[5];
		// Complete this part
		System.out.print("Enter five integer: ");
		inputArray[0] = reader.nextInt();
		inputArray[1] = reader.nextInt();
		inputArray[2] = reader.nextInt();
		inputArray[3] = reader.nextInt();
		inputArray[4] = reader.nextInt();
		
		int evenSum = 0;
		int oddSum = 0;
		
		for (int i=0; i <=4; i++) {
			if ((inputArray[i]%2) == 0) {
				evenSum = evenSum+inputArray[i];
			} else {
				oddSum = oddSum+inputArray[i];
			}
		}
		if (evenSum > oddSum) {
			flag = true;
		} else {
			flag = false;
		}
		// print out answer
		System.out.print("Answer: " + flag);
	}

}
