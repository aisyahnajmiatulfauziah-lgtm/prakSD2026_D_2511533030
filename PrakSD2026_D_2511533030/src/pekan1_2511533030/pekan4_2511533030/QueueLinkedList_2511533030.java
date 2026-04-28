package pekan4_2511533030;
import java.util.Queue;
import java.util.LinkedList;
public class QueueLinkedList_2511533030 {
	public static void main(String[] args) {
		Queue<Integer> q_3030 = new LinkedList<>();
		// tambah elemen {0, 1, 2, 3, 4, 5} ke antrian
		for (int i = 0; i < 6; i++)
			q_3030.add(i);
		// Menampilkan isi antrian.
		System.out.println("Elemen Antrian " + q_3030);
		// Untuk menghapus kepala antrian.
		int hapus = q_3030.remove();
		System.out.println("Hapus elemen = + hapus");
		System.out.println(q_3030);
		// Untuk melihat antrian terdepan
		int depan = q_3030.peek();
		System.out.println("Kepala Antrian = " + depan);
		
		int banyak = q_3030.size();
		System.out.println("Size Antrian = " + banyak);
	}

}
