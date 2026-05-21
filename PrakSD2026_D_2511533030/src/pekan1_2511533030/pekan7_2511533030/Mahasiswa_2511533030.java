package pekan7_2511533030;

public class Mahasiswa_2511533030 {
	  private String nama_3030;
	    private String nim_3030;
	    private String prodi_3030;

	    // constructor
	    public Mahasiswa_2511533030(String nama_3030, String nim_3030, String prodi_3030) {
	        this.nama_3030 = nama_3030;
	        this.nim_3030 = nim_3030;
	        this.prodi_3030 = prodi_3030;
	    }

	    // getter setter
	    public String getNama() {
	        return nama_3030;
	    }

	    public void setNama(String nama_3030) {
	        this.nama_3030 = nama_3030;
	    }

	    public String getNim() {
	        return nim_3030;
	    }

	    public void setNim(String nim_3030) {
	        this.nim_3030 = nim_3030;
	    }

	    public String getProdi() {
	        return prodi_3030;
	    }

	    public void setProdi(String prodi) {
	        this.prodi_3030 = prodi;
	    }

	    @Override
	    public String toString() {
	        return nama_3030 + " - " + nim_3030 + " - " + prodi_3030;
	    }
	}

