import java.util.Scanner;
public class Q6_55695318 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		   
		System.out.print("Enter endpoints of 1st line segment: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
			   
		System.out.print("Enter endpoints of 2nd line segment: ");
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		double x4 = input.nextDouble();
		double y4 = input.nextDouble();

		// COMPLETE the remaining part to compute the point of intersection
		
		//fixing to general formula
		double A = y1-y2;
		double B = (-x1 + x2);
		double E = (-y1*(x1-x2))+(x1*(y1-y2));
		double C = y3-y4;
		double D = (-x3 + x4);
		double F = (-y3*(x3-x4))+(x3*(y3-y4));
		
		LinearEquation result = new LinearEquation(A,B,C,D,E,F);
		System.out.print("The intersection point is: ");
		if (result.isSolvable()==true) {
			System.out.println("(" + result.getX()+ ","+result.getY()+")");
		} else {
			System.out.println("Not Solvable");
		}
		
	}
}

// Complete the definition of this class
class LinearEquation { 
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	LinearEquation(double A, double B, double C, double D, double E, double F){
		a = A;
		b = B;
		c = C;
		d = D;
		e = E;
		f = F;
	}

	public boolean isSolvable() {
		if (((a*d)-(b*c)) != 0) {
			return true;
		} else {
			return false;
		}
	}
	public double getY() {
		double Y = ((a*f)-(e*c))/((a*d)-(b*c));
		return Y;
	}
	public double getX() {
		double X = ((e*d)-(b*f))/((a*d)-(b*c));
		return X;
	}
}
