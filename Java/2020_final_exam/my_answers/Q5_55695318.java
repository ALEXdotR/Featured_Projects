import java.util.Scanner;
public class Q5_55695318 {

	public static void main(String[] args) {
		int [] database =
			{   1,   2,   3,  4,   10,  11,  15,  16,  17,  18,
			   22,  23,  24,  25,  31,  35,  36,  38,  40,  42,
			   52,  53,  55,  59,  63,  78,  82,  85,  100, 101,
			  102, 103, 104, 105, 111, 112, 113, 138, 140, 142,
			  145, 146, 147, 148, 149, 150, 165, 167, 169, 175,
			  185, 186, 188, 201, 202, 203, 205, 212, 213, 215,
			  235, 238, 250, 251, 253, 254, 255, 256, 259, 260,
			  280, 285, 290, 300, 301, 302, 303, 310, 317, 318,
			  355, 356, 357, 410, 420, 421, 423, 435, 455, 456,
			  457, 458, 459, 460, 468, 500, 501, 502, 503, 504
			};
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Input n: ");
		int n = reader.nextInt();
		
		System.out.println("Answer: " + miss(database, n));
	}

	// MODIFY and COMPLETE this method
	public static int miss(int [] database, int n) {
		int countMiss = 0;
		for (int i=1; i<=n; i++) {
			int countOnei = 0;
			for (int y=0; y<= database.length-1;y++) {
				if (i == database[y]) {
					countOnei++;
				}
			}
			if (countOnei == 0) {
				countMiss++;
			}
		}
		return countMiss;
	}

}
