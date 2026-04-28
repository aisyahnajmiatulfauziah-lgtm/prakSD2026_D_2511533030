package pekan4_2511533030;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReverseData_2511533030 {
	public static void main(String[] args) {
		Queue<Integer> q_3030 = new LinkedList<Integer>();
		q_3030.add(1);
		q_3030.add(2);
		q_3030.add(3); // [1, 2. 3]
		System.out.println("sebeleum reverse" + q_3030);
		Stack<Integer> s = new Stack<Integer>();
		while (!q_3030.isEmpty()) { // Q -> S
			s.push(q_3030.remove());
		}
		while (!s.isEmpty()) {
		q_3030.add((s.pop()));
		}
		System.out.println("sesudah reverse= " + q_3030); // [3, 2, 1]
	 }
}


