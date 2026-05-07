package pekan5_2511533030;

import java.util.Scanner;

public class RumahSakit_2511533030 {
    private Pasien_2511533030 head_3030;
    private int counter_3030;

    public RumahSakit_2511533030() {
        head_3030 = null;
        counter_3030 = 0;
    }

    public void daftarkanPasien_3030(String nama_3030, String penyakit_3030) {
        counter_3030++;
        Pasien_2511533030 newPasien_3030 = new Pasien_2511533030(nama_3030, penyakit_3030, counter_3030);
        if (head_3030 == null) head_3030 = newPasien_3030;
        else {
            Pasien_2511533030 temp_3030 = head_3030;
            while (temp_3030.getNext_3030() != null) temp_3030 = temp_3030.getNext_3030();
            temp_3030.setNext_3030(newPasien_3030);
        }
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counter_3030);
    }

    public void panggilPasien_3030() {
        if (head_3030 == null) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Memanggil Pasien: " + head_3030.getNamaPasien_3030() +
                " | Keluhan: " + head_3030.getPenyakit_3030() +
                " | Nomor Antrian: " + head_3030.getNomorAntrian_3030());
        head_3030 = head_3030.getNext_3030();
    }

    public void tampilkanAntrian_3030() {
        if (head_3030 == null) { System.out.println("Antrian kosong!"); return; }
        Pasien_2511533030 temp_3030 = head_3030;
        System.out.println("=== Daftar Antrian Pasien ===");
        while (temp_3030 != null) {
            System.out.println("Nomor: " + temp_3030.getNomorAntrian_3030() +
                    " | Nama: " + temp_3030.getNamaPasien_3030() +
                    " | Keluhan: " + temp_3030.getPenyakit_3030());
            temp_3030 = temp_3030.getNext_3030();
        }
    }

    public void cariPasien_3030(String nama_3030) {
        Pasien_2511533030 temp_3030 = head_3030;
        while (temp_3030 != null) {
            if (temp_3030.getNamaPasien_3030().equalsIgnoreCase(nama_3030)) {
                System.out.println("Pasien ditemukan! Nomor Antrian: " + temp_3030.getNomorAntrian_3030() +
                        " | Nama: " + temp_3030.getNamaPasien_3030() +
                        " | Keluhan: " + temp_3030.getPenyakit_3030());
                return;
            }
            temp_3030 = temp_3030.getNext_3030();
        }
        System.out.println("Pasien dengan nama " + nama_3030 + " tidak ditemukan.");
    }

    public void cekStatusAntrian_3030() {
        if (head_3030 == null) { System.out.println("Antrian kosong!"); return; }
        int jumlah_3030 = 0;
        Pasien_2511533030 temp_3030 = head_3030;
        while (temp_3030 != null) { jumlah_3030++; temp_3030 = temp_3030.getNext_3030(); }
        System.out.println("Jumlah pasien: " + jumlah_3030);
        System.out.println("Pasien terdepan: " + head_3030.getNamaPasien_3030() +
                " | Keluhan: " + head_3030.getPenyakit_3030());
    }

    public static void main(String[] args) {
        Scanner sc_3030 = new Scanner(System.in);
        RumahSakit_2511533030 rs_3030 = new RumahSakit_2511533030();
        int pilihan_3030;

        do {
            System.out.println("\n=== Antrian Rumah Sakit SLL NIM: 2511533030 ===");
            System.out.println("1. Daftarkan Pasien");
            System.out.println("2. Panggil Pasien");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan_3030 = sc_3030.nextInt();
            sc_3030.nextLine();

            switch (pilihan_3030) {
                case 1 -> {
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama_3030 = sc_3030.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String penyakit_3030 = sc_3030.nextLine();
                    rs_3030.daftarkanPasien_3030(nama_3030, penyakit_3030);
                }
                case 2 -> rs_3030.panggilPasien_3030();
                case 3 -> rs_3030.tampilkanAntrian_3030();
                case 4 -> {
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cari_3030 = sc_3030.nextLine();
                    rs_3030.cariPasien_3030(cari_3030);
                }
                case 5 -> rs_3030.cekStatusAntrian_3030();
                case 6 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan_3030 != 6);
        sc_3030.close();
    }
}