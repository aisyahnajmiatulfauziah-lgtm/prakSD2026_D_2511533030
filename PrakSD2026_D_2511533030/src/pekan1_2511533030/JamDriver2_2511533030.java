package pekan1_2511533030;
import java.util.Scanner;
public class JamDriver2_2511533030 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=== Program Driver Objek Jam ===");
		// 1. Input Jam Pertama
		System.out.println("\n--- Input Jam 1 ---");
		Jam_2511533030 j1 = buatJamDariInput(input);
		
		// 2. Input Jam Kedua
		System.out.println("\n--- Input Jam 2 ---");
		Jam_2511533030 j2 = buatJamDariInput(input);
		
		// 3. Menampilkan Data
		System.out.println("\n--- Hasil Operasi ---");
		System.out.println("Jam 1 (String)        : " + j1.toString());
		System.out.println("Jam 2 (String)        : " + j2.toString());
		System.out.println("Jam 1 dalam detik     : " + j1.toSeconds());
		System.out.println("Jam 2 dalam detik     : " + j2.toSeconds());
		
		// 4. Operasi Relasional (Perbandingan)
		int perbandingan = j1.compareTo(j2);
		if (perbandingan > 0 ) {
			System.out.println("Status           : Jam 1 lebih lambat (setelah) Jam 2");
		} else if (perbandingan < 0)  {
			System.out.println("Status           : Jam 1 lebih awal (sebelum) Jam 2");
		} else {
			System.out.println("Status           : Jam 1 dan jam 2 sama persis");
		}
		
		// 5. Operasi Aritmatika 
		System.out.println("Durasi (J1 ke J2)   : " + Jam_2511533030.durasiDetik(j1, j2) + " detik");
		
		Jam_2511533030 jNext = j1.nextSecond();
		System.out.println("Jam 1 Detik Berikutnya: " + jNext);
		
		Jam_2511533030 jPrev = j1.prevSecond();
		System.out.println("Jam 1 Detik Sebelumnya: " + jPrev);
		
		// 6. Operasi Penjumlahan Jam
		Jam_2511533030 jHasilPlus = (j2);
		System.out.println("Hasil J1 + J2        : " + jHasilPlus);
		
		input.close();
		System.out.println("\nProgram Selesai.");
	}	
		/**
		 * Prosedur Pembantu untuk melakukan input dan validasi secara berulang
		 * sampai user memasukkan angka yang benar (0..23, 0..59).
		 */
		private static Jam_2511533030 buatJamDariInput(Scanner sc) {
			int h, m, s;
			while (true) {
				System.out.println("Masukkan Jam (0-23)    : ");
				h = sc.nextInt();
				System.out.println("Masukkan Menit (0-59)    : ");
				m = sc.nextInt();
				System.out.println("Masukkan Detik (0-59)    : ");
				s = sc.nextInt();
				
				
				// Memanggil method static isValid dari kelas Jam
				if (Jam_2511533030.isValid(h, m, s)) {;
				   return new Jam_2511533030(h, m, s);
			    }else {
			    	System.out.println("[Eror] Input tidak valid! Silahkan ulangi. \n");
			    }
		}
		
	}

}
