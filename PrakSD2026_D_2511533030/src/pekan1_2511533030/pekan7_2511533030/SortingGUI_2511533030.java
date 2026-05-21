package pekan7_2511533030;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SortingGUI_2511533030 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// 1. DEKLARASI KOMPONEN GUI
	private JTextField txtNama, txtNim, txtProdi;
	private JButton btnTambah, btnHapus, btnSort;
	private JComboBox<String> cmbAlgoritma;
	private JTable tabelData;
	private DefaultTableModel tableModel;
	private JTextArea txtAreaLog;

	// Tempat menyimpan database Mahasiswa sementara di memori
	private ArrayList<Mahasiswa_2511533030> listMahasiswa;

	/**
	 * Create the frame.
	 */
	public SortingGUI_2511533030() {
		// 2. PENGATURAN FRAME UTAMA
		setTitle("Pengurutan Nama Mahasiswa - Pekan 7");
		setSize(850, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Membuat window muncul di tengah layar
		
		listMahasiswa = new ArrayList<>();

		// Inisialisasi contentPane bawaan eclipse
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(15, 15));

		// 3. MEMBUAT PANEL INPUT (Bagian Atas)
		JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
		panelInput.setBorder(BorderFactory.createTitledBorder("Form Input Mahasiswa"));

		panelInput.add(new JLabel("  NIM Mahasiswa:"));
		txtNim = new JTextField();
		panelInput.add(txtNim);

		panelInput.add(new JLabel("  Nama Mahasiswa:"));
		txtNama = new JTextField();
		panelInput.add(txtNama);

		panelInput.add(new JLabel("  Program Studi:"));
		txtProdi = new JTextField();
		panelInput.add(txtProdi);

		btnTambah = new JButton("Tambah Data");
		btnHapus = new JButton("Kosongkan Semua Data");
		panelInput.add(btnTambah);
		panelInput.add(btnHapus);
		contentPane.add(panelInput, BorderLayout.NORTH);

		// 4. MEMBUAT PANEL KONTROL & TABEL (Bagian Tengah)
		JPanel panelTengah = new JPanel(new BorderLayout(10, 10));
		
		// Sub-panel untuk pilihan dropdown dan tombol urutkan
		JPanel panelSaring = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSaring.add(new JLabel("Pilih Algoritma Sorting: "));
		String[] pilihanAlgoritma = {"Insertion Sort", "Selection Sort", "Bubble Sort"};
		cmbAlgoritma = new JComboBox<>(pilihanAlgoritma);
		panelSaring.add(cmbAlgoritma);
		
		btnSort = new JButton("Mulai Sorting");
		panelSaring.add(btnSort);
		panelTengah.add(panelSaring, BorderLayout.NORTH);

		// Membuat JTable untuk display data tabular (Sudah Diperbaiki agar tidak Null)
		String[] kolom = {"NIM", "Nama Mahasiswa", "Program Studi"};
		tableModel = new DefaultTableModel(kolom, 0);
		tabelData = new JTable(tableModel);
		JScrollPane scrollTabel = new JScrollPane(tabelData);
		scrollTabel.setPreferredSize(new Dimension(800, 150));
		panelTengah.add(scrollTabel, BorderLayout.CENTER);
		contentPane.add(panelTengah, BorderLayout.CENTER);

		// 5. MEMBUAT PANEL LOG VISUALISASI (Bagian Bawah)
		JPanel panelBawah = new JPanel(new BorderLayout());
		panelBawah.setBorder(BorderFactory.createTitledBorder("Visualisasi Proses Langkah demi Langkah"));
		
		txtAreaLog = new JTextArea();
		txtAreaLog.setEditable(false); // Log tidak bisa diketik manual oleh user
		txtAreaLog.setFont(new Font("Monospaced", Font.PLAIN, 13)); // Font code agar rapi
		JScrollPane scrollLog = new JScrollPane(txtAreaLog);
		scrollLog.setPreferredSize(new Dimension(800, 220));
		panelBawah.add(scrollLog, BorderLayout.CENTER);
		contentPane.add(panelBawah, BorderLayout.SOUTH);

		// 7. LOGIKA AKSI TOMBOL (EVENT HANDLING)
		
		// Aksi Tombol Tambah
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tambahDataKeList();
			}
		});

		// Aksi Tombol Hapus
		btnHapus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listMahasiswa.clear();
				refreshTabel();
				txtAreaLog.setText("");
			}
		});

		// Aksi Tombol Jalankan Sorting
		btnSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eksekusiSorting();
			}
		});
	}

	// METHOD AMBIL INPUT DAN MASUKKAN KE ARRAYLIST
	private void tambahDataKeList() {
		String nim = txtNim.getText().trim();
		String nama = txtNama.getText().trim();
		String prodi = txtProdi.getText().trim();

		// Validasi jika ada textfield kosong
		if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Isi semua data terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Buat objek mahasiswa baru, masukkan ke list
		Mahasiswa_2511533030 mhs = new Mahasiswa_2511533030(nama, nim, prodi);
		listMahasiswa.add(mhs);
		
		// Perbarui JTable
		refreshTabel();

		// Reset textfield agar kosong kembali
		txtNim.setText("");
		txtNama.setText("");
		txtProdi.setText("");
		txtNim.requestFocus(); // Kursor otomatis fokus ke kolom NIM lagi
	}

	// METHOD REFRESH JTABLE
	private void refreshTabel() {
		tableModel.setRowCount(0); // Hapus semua baris lama di tabel
		for (Mahasiswa_2511533030 mhs : listMahasiswa) {
			// Masukkan data objek ke baris tabel baru
			tableModel.addRow(new Object[]{mhs.getNim(), mhs.getNama(), mhs.getProdi()});
		}
	}

	// METHOD PENGARAH ALGORITMA YANG DIPILIH
	private void eksekusiSorting() {
		if (listMahasiswa.size() < 2) {
			JOptionPane.showMessageDialog(this, "Masukkan minimal 2 data mahasiswa untuk diurutkan!", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		// Kita clone ke ArrayList baru agar data asli tidak teracak permanen sebelum dicoba dengan metode lain
		ArrayList<Mahasiswa_2511533030> dataUrut = new ArrayList<>(listMahasiswa);
		txtAreaLog.setText(""); // Bersihkan teks log lama

		String algoritmaTerpilih = (String) cmbAlgoritma.getSelectedItem();
		
		// Pengecekan kondisi algoritma mana yang dijalankan
		if (algoritmaTerpilih.equals("Insertion Sort")) {
			jalankanInsertionSort(dataUrut);
		} else if (algoritmaTerpilih.equals("Selection Sort")) {
			jalankanSelectionSort(dataUrut);
		} else if (algoritmaTerpilih.equals("Bubble Sort")) {
			jalankanBubbleSort(dataUrut);
		}

		// Setelah selesai disort, masukkan hasil urutan ke database utama dan refresh tabel
		listMahasiswa = dataUrut;
		refreshTabel();
	}

	// =======================================================
	// LOGIKA DASAR CODING SORTING MENGGUNAKAN compareToIgnoreCase
	// =======================================================

	private void jalankanInsertionSort(ArrayList<Mahasiswa_2511533030> arr) {
		txtAreaLog.append("=== INSERTION SORT ===\n");
		txtAreaLog.append("Awal : " + arr.toString() + "\n\n");
		
		int n = arr.size();
		for (int i = 1; i < n; i++) {
			Mahasiswa_2511533030 key = arr.get(i);
			int j = i - 1;

			// Membandingkan String menggunakan compareToIgnoreCase sesuai kriteria soal
			while (j >= 0 && arr.get(j).getNama().compareToIgnoreCase(key.getNama()) > 0) {
				arr.set(j + 1, arr.get(j));
				j = j - 1;
			}
			arr.set(j + 1, key);
			
			// Cetak langkah visualisasi ke JTextArea
			txtAreaLog.append("Langkah " + i + " : " + arr.toString() + "\n");
		}
		txtAreaLog.append("\nStatus: Pengurutan Sukses Berhasil!");
	}

	private void jalankanSelectionSort(ArrayList<Mahasiswa_2511533030> arr) {
		txtAreaLog.append("=== SELECTION SORT ===\n");
		txtAreaLog.append("Awal : " + arr.toString() + "\n\n");

		int n = arr.size();
		for (int i = 0; i < n - 1; i++) {
			int indeksMinimal = i;
			for (int j = i + 1; j < n; j++) {
				if (arr.get(j).getNama().compareToIgnoreCase(arr.get(indeksMinimal).getNama()) < 0) {
					indeksMinimal = j;
				}
			}
			// Swap atau penukaran posisi objek
			Mahasiswa_2511533030 temp = arr.get(indeksMinimal);
			arr.set(indeksMinimal, arr.get(i));
			arr.set(i, temp);

			// Cetak langkah putaran (Pass) ke JTextArea
			txtAreaLog.append("Pass " + (i + 1) + "    : " + arr.toString() + "\n");
		}
		txtAreaLog.append("\nStatus: Pengurutan Sukses Berhasil!");
	}

	private void jalankanBubbleSort(ArrayList<Mahasiswa_2511533030> arr) {
		txtAreaLog.append("=== BUBBLE SORT ===\n");
		txtAreaLog.append("Awal : " + arr.toString() + "\n\n");

		int n = arr.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				// Bandingkan elemen kiri dengan elemen kanannya
				if (arr.get(j).getNama().compareToIgnoreCase(arr.get(j + 1).getNama()) > 0) {
					// Tukar posisi elemen
					Mahasiswa_2511533030 temp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, temp);
				}
			}
			// Cetak langkah putaran (Pass) ke JTextArea
			txtAreaLog.append("Pass " + (i + 1) + "    : " + arr.toString() + "\n");
		}
		txtAreaLog.append("\nStatus: Pengurutan Sukses Berhasil!");
	}

	// 8. MAIN METHOD UTAMA YANG SUDAH DIPERBAIKI SINKRONISASINYA
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortingGUI_2511533030 frame = new SortingGUI_2511533030();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}