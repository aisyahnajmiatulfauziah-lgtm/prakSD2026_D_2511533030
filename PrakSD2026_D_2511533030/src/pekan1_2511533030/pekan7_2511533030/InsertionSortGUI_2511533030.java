package pekan7_2511533030;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing. JTextArea;
public class InsertionSortGUI_2511533030 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane_3030;
	private int[] array_3030;
	private JLabel[] labelArray_3030;
	private JButton stepButton_3030, resetButton_3030, setButton_3030;
	private JTextField inputField_3030;
	private JPanel panelArray_3030;
	private JTextArea stepArea_3030;
	
	private int i_3030 = 1, j_3030;
	private boolean sorting_3030 = false;
	private int stepCount_3030 = 1;
	/**
	 * Create the frame.
	 */
	public InsertionSortGUI_2511533030() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane_3030 = new JPanel();
		contentPane_3030.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_3030);
		 setTitle("Insertion Sort Langkah per Langkah");
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
		    JScrollPane scrollPanel_3030 = new JScrollPane(stepArea_3030);

		    // Tambahkan panel ke frame
		    add(inputPanel_3030, BorderLayout.NORTH);
		    add(panelArray_3030, BorderLayout.CENTER);
		    add(controlPanel_3030, BorderLayout.SOUTH);
		    add(scrollPanel_3030, BorderLayout.EAST);

		    // Event Set Array
		    setButton_3030.addActionListener(e -> setArrayFromInput());

		    // Event Langkah Selanjutnya
		    stepButton_3030.addActionListener(e -> performStep());

		    // Event Reset
		    resetButton_3030.addActionListener(e -> reset());
		    
		    
		}
	private void setArrayFromInput() {
	    String text = inputField_3030.getText().trim();
	    if (text.isEmpty()) return;

	    String[] parts = text.split(",");
	    array_3030= new int[parts.length];

	    try {
	        for (int k = 0; k < parts.length; k++) {
	            array_3030[k] = Integer.parseInt(parts[k].trim());
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan "
	                + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    i_3030 = 1;
	    sorting_3030 = true;
	    stepButton_3030.setEnabled(true);
	    stepArea_3030.setText("");

	    panelArray_3030.removeAll();
	    labelArray_3030 = new JLabel[array_3030.length];

	    for (int k_3030 = 0; k_3030 < array_3030.length; k_3030++) {
	        labelArray_3030[k_3030] = new JLabel(String.valueOf(array_3030[k_3030]));
	        labelArray_3030[k_3030].setFont(new Font("Arial", Font.BOLD, 24));
	        labelArray_3030[k_3030].setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        labelArray_3030[k_3030].setPreferredSize(new Dimension(50, 50));
	        labelArray_3030[k_3030].setHorizontalAlignment(SwingConstants.CENTER);

	        panelArray_3030.add(labelArray_3030[k_3030]);
	    }

	    panelArray_3030.revalidate();
	    panelArray_3030.repaint();
	}
	private void performStep() {
	    if (i_3030 < array_3030.length && sorting_3030) {
	        int key_3030 = array_3030[i_3030];
	        j_3030 = i_3030 - 1;

	        StringBuilder stepLog = new StringBuilder();
	        Object stepCount;
			stepLog.append("Langkah ").append(stepCount_3030).
	                append(": Memasukkan ").append(key_3030).append("\n");

	        while (j_3030 >= 0 && array_3030[j_3030] > key_3030) {
	            array_3030[j_3030 + 1] = array_3030[j_3030];
	            j_3030--;
	        }

	        array_3030[j_3030 + 1] = key_3030;

	        updateLabels();
	        stepLog.append("Hasil: ").append(arrayToString(array_3030)).append("\n\n");
	        stepArea_3030.append(stepLog.toString());

	        i_3030++;
	        stepCount_3030++;

	        if (i_3030 == array_3030.length) {
	            sorting_3030 = false;
	            stepButton_3030.setEnabled(false);
	            JOptionPane.showMessageDialog(this, "Sorting selesai!");
	        }
	    }
	}
	private void updateLabels() {
	    for (int k_3030 = 0; k_3030 < array_3030.length; k_3030++) {
	        labelArray_3030[k_3030].setText(String.valueOf(array_3030[k_3030]));
	    }
	}

	private void reset() {
	    inputField_3030.setText("");
	    panelArray_3030.removeAll();
	    panelArray_3030.revalidate();
	    panelArray_3030.repaint();
	    stepArea_3030.setText("");
	    stepButton_3030.setEnabled(false);
	    sorting_3030 = false;
	    i_3030 = 1;
	    stepCount_3030 = 1;
	}

	private String arrayToString(int[] arr) {
	    StringBuilder sb = new StringBuilder();
	    for (int k_3030 = 0; k_3030 < arr.length; k_3030++) {
	        sb.append(arr[k_3030]);
	        if (k_3030 < arr.length - 1) sb.append(", ");
	    }
	    return sb.toString();
	}

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        InsertionSortGUI_2511533030 gui_3030 = new InsertionSortGUI_2511533030();
	        gui_3030.setVisible(true);
	    });
	}
	}


