import java.util.Scanner;
public class Q7_55695318 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Input m: ");
		int m = reader.nextInt();
		System.out.print("Input n: ");
		int n = reader.nextInt();
		
		// COMPLETE your program here
		// You may use methods
		StackOfIntegers stack = new StackOfIntegers();
		int cap = 0;
		int a=0;
		int b=0;
		if (m>=n) {
			cap = m-n;
			a=n;
			b=m;
		} else {
			cap = n-m;
			a=m;
			b=n;
		}
		while (a<=b) {
			String astr=Integer.toString(a);
			int count = 0;
			for (int i=0; i<=astr.length()-1;i++) {
				if (astr.charAt(i)==astr.charAt(astr.length()-1-i)) {
					count++;
				}
			}
			if (count>0) {
				stack.push(a);
			}
			a++;
		}
		while (stack.getSize()!=0) {
			System.out.print(stack.pop());
		}

		
		
	}
}
class StackOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 2000;

	/** Construct a stack with the default capacity 16 */
	public StackOfIntegers() {
		 this(DEFAULT_CAPACITY);
	}

	/** Construct a stack with the specified capacity */
	public StackOfIntegers(int capacity) {
		 elements = new int[capacity];
	}

	/** Push a new integer into the top of the stack */
	public void push(int value) {
		if (size >= elements.length) {
		      int[] temp = new int[elements.length * 2];
		      System.arraycopy(elements, 0, temp, 0, elements.length);
		      elements = temp;
		}

		elements[size++] = value;
	}

	/** Return and remove the top element from the stack */
	public int pop() {
		return elements[--size];
	}

	/** Return the top element from the stack */
	public int peek() {
		return elements[size - 1];
	}

	/** Test whether the stack is empty */
	public boolean empty() {
		return size == 0;
	}

	/** Return the number of elements in the stack */
	public int getSize() {
		return size;
	}
}