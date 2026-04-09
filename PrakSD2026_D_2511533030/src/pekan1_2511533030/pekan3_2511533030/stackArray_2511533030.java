package pekan3_2511533030;

public class stackArray_2511533030 {
	static final int MAX_3030 = 1000;
	int top_3030;
	int a_3030[] = new int[MAX_3030];
	boolean isEmpty_3030()
	{
		return (top_3030 < 0);
	}
	stackArray_2511533030()
	{
		top_3030 = -1;
	}
	boolean push_3030(int X)
	{
		if (top_3030 >= (MAX_3030 - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a_3030[++top_3030] = X;
			System.out.println(X + " dimasukkan dalam stack");
			return true;
		}
	}
	int pop_3030()
	{
		if (top_3030 < 0) {
			System.out.println("Stack Underflow ");
			return 0;
		}
		else {
			int X = a_3030[top_3030--];
			return X;
		}
	}
	int peek_3030()
	{
		if (top_3030 < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int X = a_3030[top_3030];
			return X;
		}
	}
	void print() {
		for(int i = top_3030;i>-1;i--) {
			System.out.println(" "+ a_3030[i]);
		}
	}
	

}
