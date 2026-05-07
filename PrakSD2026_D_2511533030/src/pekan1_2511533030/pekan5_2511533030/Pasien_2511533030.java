package pekan5_2511533030;

public class Pasien_2511533030 {
    private String namaPasien_3030;
    private String penyakit_3030;
    private int nomorAntrian_3030;
    Pasien_2511533030 next_3030;

    public Pasien_2511533030(String namaPasien_3030, String penyakit_3030, int nomorAntrian_3030) {
        this.namaPasien_3030 = namaPasien_3030;
        this.penyakit_3030 = penyakit_3030;
        this.nomorAntrian_3030 = nomorAntrian_3030;
        this.next_3030 = null;
    }

    public String getNamaPasien_3030() { return namaPasien_3030; }
    public String getPenyakit_3030() { return penyakit_3030; }
    public int getNomorAntrian_3030() { return nomorAntrian_3030; }
    public Pasien_2511533030 getNext_3030() { return next_3030; }

    public void setNext_3030(Pasien_2511533030 next_3030) { this.next_3030 = next_3030; }
}