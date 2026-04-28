package pekan4_2511533030;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
public class IterasiQueue_251153030 {
		public static void main (String args[])
		{
			Queue<String> q_3030 = new LinkedList<>();
			
			q_3030.add("Pratikum");
			q_3030.add("Struktur");
			q_3030.add("Data");
			q_3030.add("Dan");
			q_3030.add("Algortima");
			Iterator<String> iterator = q_3030.iterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next() + " ");
			}
			
		}

}
