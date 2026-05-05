package pekan5_2511533030;

public class PencarianSLL_2511533030 {
	static boolean searchKey_3014 (NodeSLL_2511533030 head, int key) {
		NodeSLL_2511533030 curr_3030 = head;
		while (curr_3030 != null) {
			if (curr_3030.data_3030 == key)
				return true;
			curr_3030 = curr_3030.next_3030; }
		return false; }
	public static void traversal_3014 (NodeSLL_2511533030 head) {
		//mulai dari head
		NodeSLL_2511533030 curr_3030 = head;
		// telusuri sampai pointer null
		while (curr_3030 != null)  {
			System.out.print(" " + curr_3030.data_3030);
			curr_3030 = curr_3030.next_3030; }
		System.out.println();      }
		public static void main (String[] args) {
			NodeSLL_2511533030 head = new NodeSLL_2511533030(14);
			head.next_3030 = new NodeSLL_2511533030(21);
			head.next_3030.next_3030 = new NodeSLL_2511533030(13);
			head.next_3030.next_3030.next_3030 = new NodeSLL_2511533030(30);
			head.next_3030.next_3030.next_3030.next_3030 = new NodeSLL_2511533030(10);
			System.out.print ("Penelusuran SLL : ") ;
			traversal_3014 (head);
			// data yang akan dicari
			int key = 30;
			System.out.print("cari data " + key+ "  =  ");
			if (searchKey_3014(head, key))
				System.out.println("ketemu");
			else
				System.out.println("tidak ada");
	
			
		}
	}