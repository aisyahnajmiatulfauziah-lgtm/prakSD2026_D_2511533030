package pekan8_2511533030; // Tetap mempertahankan nama package bawaan Anda

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font; 
import java.util.Queue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MergeSortGUI_2511533030 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane_3030;
	private int[] array_3030;
	private JLabel[] labelArray_3030;
	private JButton stepButton_3030, resetButton_3030, setButton_3030;
	private JTextField inputField_3030;
	private JPanel panelArray_3030;
	private JTextArea stepArea_3030;
	
	private boolean sorting_3030 = false;
	private boolean copying_3030 = false;
	private boolean isMerging_3030 = false;
	
	private int stepCount_3030 = 1;
	private java.util.Queue<int[]> mergeQueue_3030 = new java.util.LinkedList<>();
	private int left_3030, mid_3030, right_3030;
	private int[] temp_3030;
	private int i_3030, j_3030, k_3030;

	/**
	 * Create the frame.
	 */
	public MergeSortGUI_2511533030() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane_3030 = new JPanel();
		contentPane_3030.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_3030);
		
		setTitle("Merge Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Panel input
		JPanel inputPanel_3030 = new JPanel(new FlowLayout());
		inputField_3030 = new JTextField(30);
		setButton_3030 = new JButton("Set Array");
		inputPanel_3030.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
		inputPanel_3030.add(inputField_3030);
		inputPanel_3030.add(setButton_3030);

		// Panel array visual
		panelArray_3030 = new JPanel();
		panelArray_3030.setLayout(new FlowLayout());

		// Panel kontrol
		JPanel controlPanel_3030 = new JPanel();
		stepButton_3030 = new JButton("Langkah Selanjutnya");
		resetButton_3030 = new JButton("Reset");
		stepButton_3030.setEnabled(false);
		controlPanel_3030.add(stepButton_3030);
		controlPanel_3030.add(resetButton_3030);
		
		// Area teks untuk log langkah-langkah
		stepArea_3030 = new JTextArea(8, 60);
		stepArea_3030.setEditable(false);
		stepArea_3030.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane_3030 = new JScrollPane(stepArea_3030);

		// Tambahkan panel ke frame
		add(inputPanel_3030, BorderLayout.NORTH);
		add(panelArray_3030, BorderLayout.CENTER);
		add(controlPanel_3030, BorderLayout.SOUTH);
		add(scrollPane_3030, BorderLayout.EAST);

		// Event Set Array
		setButton_3030.addActionListener(e -> setArrayFromInput_3030());

		// Event Langkah Selanjutnya
		stepButton_3030.addActionListener(e -> performStep_3030());

		// Event Reset
		resetButton_3030.addActionListener(e -> reset_3030());
	}

	private void setArrayFromInput_3030() {
		String text = inputField_3030.getText().trim();
		if (text.isEmpty()) return;
		String[] parts = text.split(",");
		array_3030 = new int[parts.length];
		try {
			for (int i = 0; i < parts.length; i++) {
				array_3030[i] = Integer.parseInt(parts[i].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		labelArray_3030 = new JLabel[array_3030.length];
		panelArray_3030.removeAll();

		for (int i = 0; i < array_3030.length; i++) {
			labelArray_3030[i] = new JLabel(String.valueOf(array_3030[i]));
			labelArray_3030[i].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_3030[i].setOpaque(true);
			labelArray_3030[i].setBackground(Color.WHITE);
			labelArray_3030[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_3030[i].setPreferredSize(new Dimension(50, 50));
			labelArray_3030[i].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_3030.add(labelArray_3030[i]);
		}
		mergeQueue_3030.clear();
		generateMergeSteps_3030(0, array_3030.length - 1);
		
		stepButton_3030.setEnabled(true);
		stepArea_3030.setText("");
		stepCount_3030 = 1;
		isMerging_3030 = false;
		
		panelArray_3030.revalidate();
		panelArray_3030.repaint();
	}
	
	private void generateMergeSteps_3030(int left_3030, int right_3030) {
		if (left_3030 >= right_3030) {
			return;
		}
		int mid_3030 = (left_3030 + right_3030) / 2;

		generateMergeSteps_3030(left_3030, mid_3030);
		generateMergeSteps_3030(mid_3030 + 1, right_3030);

		mergeQueue_3030.add(new int[] {
				left_3030, mid_3030, right_3030
				});
	}
	
	private void performStep_3030() {
		resetHighlights_3030();
		if (!isMerging_3030 && !mergeQueue_3030.isEmpty()) {
			int[] range_3030 = mergeQueue_3030.poll();

			left_3030 = range_3030[0];
			mid_3030 = range_3030[1];
			right_3030 = range_3030[2];
			temp_3030 = new int[right_3030 - left_3030 + 1];

			i_3030 = left_3030;
			j_3030 = mid_3030 + 1;
			k_3030 = 0;

			copying_3030 = false;
			isMerging_3030 = true;
			stepArea_3030.append("Langkah " + stepCount_3030++ + ": Mulai merge dari indeks " + left_3030 + " sampai " + right_3030 + "\n");
			return;
		}

		if (isMerging_3030 && !copying_3030) {
			if (i_3030 <= mid_3030 && j_3030 <= right_3030) {
				labelArray_3030[i_3030].setBackground(Color.CYAN);
				labelArray_3030[j_3030].setBackground(Color.CYAN);
				if (array_3030[i_3030] <= array_3030[j_3030]) {
					temp_3030[k_3030++] = array_3030[i_3030++];
				} else {
					temp_3030[k_3030++] = array_3030[j_3030++];
				}
				stepArea_3030.append(
						"Langkah " + stepCount_3030++
						+ ": Bandingkan dan salin elemen\n"
						+ "Hasil: "
						+ arrayToString_3030(array_3030)
						+ "\n\n"
					);
				return;
			}
			else if (i_3030 <= mid_3030) {
				temp_3030[k_3030++] = array_3030[i_3030++];
				stepArea_3030.append(
						"Langkah " + stepCount_3030++
						+ ": Salin sisa kiri\n"
						+ "Hasil: "
						+ arrayToString_3030(array_3030)
						+ "\n\n"
					);
				return;
			}
			else if (j_3030 <= right_3030) {
				temp_3030[k_3030++] = array_3030[j_3030++];
				stepArea_3030.append(
						"Langkah " + stepCount_3030++
						+ ": Salin sisa kanan\n"
						+ "Hasil: "
						+ arrayToString_3030(array_3030)
						+ "\n\n"
					);
				return;
			}
			else {
				copying_3030 = true;
				k_3030 = 0;
				return;
			}
		}

		if (copying_3030 && k_3030 < temp_3030.length) {
			array_3030[left_3030 + k_3030] = temp_3030[k_3030];
			labelArray_3030[left_3030 + k_3030].setText(String.valueOf(temp_3030[k_3030]));
			labelArray_3030[left_3030 + k_3030].setBackground(Color.GREEN);
			k_3030++;
			stepArea_3030.append(
					"Langkah " + stepCount_3030++
					+ ": Tempelkan ke array utama\n"
					+ "Hasil: "
					+ arrayToString_3030(array_3030)
					+ "\n\n"
				);
			return;
		}
		if (copying_3030 && k_3030 == temp_3030.length) {
			isMerging_3030 = false;
			copying_3030 = false;
		}
		if (mergeQueue_3030.isEmpty() && !isMerging_3030) {
			stepArea_3030.append("Selesai.\n");
			stepButton_3030.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
		}
	}
		
	private void resetHighlights_3030() {
		if (labelArray_3030 == null) {
			return;
		}
		for (JLabel label_3030 : labelArray_3030) {
			label_3030.setBackground(Color.WHITE);
		}
	}
	
	private void reset_3030() {
		inputField_3030.setText("");
		panelArray_3030.removeAll();
		panelArray_3030.revalidate();
		panelArray_3030.repaint();
		stepArea_3030.setText("");
		stepButton_3030.setEnabled(false);
		mergeQueue_3030.clear();
		isMerging_3030 = false;
		stepCount_3030 = 1;
	}

	private String arrayToString_3030(int[] arr_3030) {
		StringBuilder sb_3030 = new StringBuilder();
		for (int k_3030 = 0; k_3030 < arr_3030.length; k_3030++) {
			sb_3030.append(arr_3030[k_3030]);
			if (k_3030 < arr_3030.length - 1) {
				sb_3030.append(", ");
			}
		}
		return sb_3030.toString();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MergeSortGUI_2511533030 gui_3030 = new MergeSortGUI_2511533030();
			gui_3030.setVisible(true); 
		});
	}
}