import java.util.Scanner;
public class Q4_55695318 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a value for i: ");
		int i = reader.nextInt();
		
		System.out.print(m(i));
	}
	
	// MODIFY and COMPLETE this method
	public static double m(int num) {
		double sum = 0;
		for (int i = 1; i <= num ; i++) {
			double temp = (double) i/((i*2)+1);
			sum = sum + temp;
		}
		int y = 0;
		int x = 1;
		if (sum>=1) {
			while (y == 0) {
				if (Math.floor(sum/x)== 0) {
					y = x;
				} else {
					x=x*10;
				}
			}
			
			double sum1 = Math.rint(sum*y*10);
			double sum2 = sum1/(y*10);
			return sum2;
		} else {
			double sum1 = Math.rint(sum*100);
			double sum2 = sum1/(100);
			return sum2;
		}
	}
}
