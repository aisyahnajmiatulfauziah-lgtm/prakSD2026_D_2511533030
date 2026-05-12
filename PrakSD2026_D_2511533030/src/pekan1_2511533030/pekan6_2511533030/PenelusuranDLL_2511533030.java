package pekan6_2511533030;

public class PenelusuranDLL_2511533030 {
	// fungsi penelusuran maju]
		static void forwardTraversal (NodeDLL_2511533030 head_3030) {
			// memulai penelusuran dari head
			NodeDLL_2511533030 curr_3030 = head_3030;
			// lanjutkan sampai akhir
			while (curr_3030 != null) {
				// print data
				System.out.print(curr_3030.data_3030 + " <-> ");
				//pindah ke node berikutnya
				curr_3030 = curr_3030.next_3030;
				
			}
			// print spasi
			System.out.println();
		}
		// fungsi penelusuran mundur
		static void backwardTraversal(NodeDLL_2511533030 tail_3030) {
			// mulai dari akhir
			NodeDLL_2511533030 curr_3030 = tail_3030;
			// lanjut sampai head
			while (curr_3030 != null) {
				// cetak data
				System.out.print(curr_3030.data_3030 + " <-> ");
				// pindah ke node sebelumnya 
				curr_3030 = curr_3030.prev_3030;
			}
			// cetak spasi
			System.out.println();
		}
		 public static void main(String[] args) {
			 // cetak DLL
			 NodeDLL_2511533030 head_3030 = new NodeDLL_2511533030(1);
			 NodeDLL_2511533030 second_3030 = new NodeDLL_2511533030(2);
			 NodeDLL_2511533030 third_3030 = new NodeDLL_2511533030(3);
			 
			 head_3030.next_3030 = second_3030;
			 second_3030.prev_3030 = head_3030;
			 second_3030.next_3030 = third_3030;
			 third_3030.prev_3030 = second_3030;
			 
			 System.out.println("Penelusuran maju:");
			 forwardTraversal(head_3030);
			 
			 System.out.println("Penelusuran mundur:");
			 backwardTraversal(third_3030);

		 }

}
