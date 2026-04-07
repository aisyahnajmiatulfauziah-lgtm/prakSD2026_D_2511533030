package pekan2_2511533030;

public class Mahasiswa_2511533030 {
	 String nim;
	    String nama;
	    String prodi;

	    Mahasiswa_2511533030(String nim, String nama, String prodi) {
	        this.nim = nim;
	        this.nama = nama;
	        this.prodi = prodi;
	    }

	    @Override
	    public String toString() {
	        return "NIM: " + nim + ", Nama: " + nama + ", Prodi: " + prodi;
	    }
	}


