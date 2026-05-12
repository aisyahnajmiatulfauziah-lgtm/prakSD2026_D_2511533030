package pekan6_2511533030;

public class HapusDLL_2511533030 {
	    // fungsi menghapus node awal
	    public static NodeDLL_2511533030 delHead(NodeDLL_2511533030 head_3030) {
	        if (head_3030 == null) {
	            return null;
	        }
	        NodeDLL_2511533030 temp = head_3030;
	        head_3030 = head_3030.next_3030;
	        if (head_3030 != null) {
	            head_3030.prev_3030 = null;
	        }
	        return head_3030;
	    }

	    // fungsi menghapus di akhir
	    public static NodeDLL_2511533030 delLast(NodeDLL_2511533030 head_3030) {
	        if (head_3030 == null) {
	            return null;
	        }
	        if (head_3030.next_3030 == null) {
	            return null;
	        }
	        NodeDLL_2511533030 curr = head_3030;
	        while (curr.next_3030 != null) {
	            curr = curr.next_3030;
	        }
	        // update pointer previous node
	        if (curr.prev_3030 != null) {
	            curr.prev_3030.next_3030 = null;
	        }
	        return head_3030;
	    }
	 // fungsi menghapus node posisi tertentu
	    public static NodeDLL_2511533030 delPos(NodeDLL_2511533030 head_3030, int pos_3030) {
	        // jika DLL kosong
	        if (head_3030 == null) {
	            return head_3030;
	        }
	        NodeDLL_2511533030 curr = head_3030;
	        // telusuri sampai ke node yang akan dihapus
	        for (int i = 1; curr != null && i < pos_3030; ++i) {
	            curr = curr.next_3030;
	        }
	        // jika posisi tidak ditemukan
	        if (curr == null) {
	            return head_3030;
	        }
	        // Update pointer
	        if (curr.prev_3030 != null) {
	            curr.prev_3030.next_3030 = curr.next_3030;
	        }
	        if (curr.next_3030 != null) {
	            curr.next_3030.prev_3030 = curr.prev_3030;
	        }
	        // jika yang dihapus head
	        if (head_3030 == curr) {
	            head_3030 = curr.next_3030;
	        }
	        return head_3030;
	    }

	    // fungsi mencetak DLL
	    public static void printList(NodeDLL_2511533030 head_3030) {
	        NodeDLL_2511533030 curr = head_3030;
	        while (curr != null) {
	            System.out.print(curr.data_3030 + " ");
	            curr = curr.next_3030;
	        }
	        System.out.println();
	    }
	    public static void main(String[] args) {

	        // buat sebuah DLL
	        NodeDLL_2511533030 head_3030 = new NodeDLL_2511533030(1);

	        head_3030.next_3030 = new NodeDLL_2511533030(2);
	        head_3030.next_3030.prev_3030 = head_3030;

	        head_3030.next_3030.next_3030 = new NodeDLL_2511533030(3);
	        head_3030.next_3030.next_3030.prev_3030 = head_3030.next_3030;

	        head_3030.next_3030.next_3030.next_3030 = new NodeDLL_2511533030(4);
	        head_3030.next_3030.next_3030.next_3030.prev_3030 = head_3030.next_3030.next_3030;

	        head_3030.next_3030.next_3030.next_3030.next_3030 = new NodeDLL_2511533030(5);
	        head_3030.next_3030.next_3030.next_3030.next_3030.prev_3030 =
	                head_3030.next_3030.next_3030.next_3030;

	        System.out.print("DLL Awal: ");
	        printList(head_3030);

	        System.out.print("Setelah head dihapus: ");
	        head_3030 = delHead(head_3030);
	        printList(head_3030);

	        System.out.print("Setelah node terakhir dihapus: ");
	        head_3030 = delLast(head_3030);
	        printList(head_3030);

	        System.out.print("menghapus node ke 2: ");
	        head_3030 = delPos(head_3030, 2);

	        printList(head_3030);
	    }
	}


