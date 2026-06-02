package pekan8_2511533030;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class BubbleSortGUI_2511533030 extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane_3030;
    private int[] array_3030;
    private JLabel[] labelArray_3030;

    private JButton stepButton_3030;
    private JButton resetButton_3030;
    private JButton setButton_3030;

    private JTextField inputField_3030;
    private JPanel panelArray_3030;
    private JTextArea stepArea_3030;

    private int i_3030 = 0;
    private int j_3030 = 0;
    private boolean sorting_3030 = false;
    private int stepCount_3030 = 1;

    public BubbleSortGUI_2511533030() {

        setTitle("Bubble Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        contentPane_3030 = new JPanel();
        contentPane_3030.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Panel Input
        JPanel inputPanel_3030 = new JPanel(new FlowLayout());

        inputField_3030 = new JTextField(30);
        setButton_3030 = new JButton("Set Array");

        inputPanel_3030.add(
                new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel_3030.add(inputField_3030);
        inputPanel_3030.add(setButton_3030);

        // Panel Array
        panelArray_3030 = new JPanel();
        panelArray_3030.setLayout(new FlowLayout());

        // Panel Kontrol
        JPanel controlPanel_3030 = new JPanel();

        stepButton_3030 = new JButton("Langkah Selanjutnya");
        resetButton_3030 = new JButton("Reset");

        stepButton_3030.setEnabled(false);

        controlPanel_3030.add(stepButton_3030);
        controlPanel_3030.add(resetButton_3030);

        // Area Log
        stepArea_3030 = new JTextArea(8, 60);
        stepArea_3030.setEditable(false);
        stepArea_3030.setFont(
                new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane_3030 =
                new JScrollPane(stepArea_3030);

        add(inputPanel_3030, BorderLayout.NORTH);
        add(panelArray_3030, BorderLayout.CENTER);
        add(controlPanel_3030, BorderLayout.SOUTH);
        add(scrollPane_3030, BorderLayout.EAST);

        setButton_3030.addActionListener(
                e -> setArrayFromInput_3030());

        stepButton_3030.addActionListener(
                e -> performStep_3030());

        resetButton_3030.addActionListener(
                e -> reset_3030());
    }

    private void setArrayFromInput_3030() {

        String text_3030 = inputField_3030.getText().trim();

        if (text_3030.isEmpty())
            return;

        String[] parts_3030 = text_3030.split(",");

        array_3030 = new int[parts_3030.length];

        try {
            for (int k_3030 = 0;
                 k_3030 < parts_3030.length;
                 k_3030++) {

                array_3030[k_3030] =
                        Integer.parseInt(
                                parts_3030[k_3030].trim());
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Masukkan hanya angka yang dipisahkan koma!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        i_3030 = 0;
        j_3030 = 0;
        stepCount_3030 = 1;
        sorting_3030 = true;

        stepButton_3030.setEnabled(true);
        stepArea_3030.setText("");

        panelArray_3030.removeAll();

        labelArray_3030 = new JLabel[array_3030.length];

        for (int k_3030 = 0;
             k_3030 < array_3030.length;
             k_3030++) {

            labelArray_3030[k_3030] =
                    new JLabel(
                            String.valueOf(array_3030[k_3030]));

            labelArray_3030[k_3030].setFont(
                    new Font("Arial", Font.BOLD, 24));

            labelArray_3030[k_3030].setOpaque(true);

            labelArray_3030[k_3030]
                    .setBackground(Color.WHITE);

            labelArray_3030[k_3030].setBorder(
                    BorderFactory.createLineBorder(
                            Color.BLACK));

            labelArray_3030[k_3030].setPreferredSize(
                    new Dimension(50, 50));

            labelArray_3030[k_3030]
                    .setHorizontalAlignment(
                            SwingConstants.CENTER);

            panelArray_3030.add(
                    labelArray_3030[k_3030]);
        }

        panelArray_3030.revalidate();
        panelArray_3030.repaint();
    }

    private void performStep_3030() {

        if (!sorting_3030 ||
                i_3030 >= array_3030.length - 1) {

            sorting_3030 = false;
            stepButton_3030.setEnabled(false);

            JOptionPane.showMessageDialog(
                    this,
                    "Sorting selesai!");

            return;
        }

        resetHighlights_3030();

        StringBuilder stepLog_3030 =
                new StringBuilder();

        labelArray_3030[j_3030]
                .setBackground(Color.CYAN);

        labelArray_3030[j_3030 + 1]
                .setBackground(Color.CYAN);

        if (array_3030[j_3030] >
                array_3030[j_3030 + 1]) {

            int temp_3030 =
                    array_3030[j_3030];

            array_3030[j_3030] =
                    array_3030[j_3030 + 1];

            array_3030[j_3030 + 1] =
                    temp_3030;

            labelArray_3030[j_3030]
                    .setBackground(Color.RED);

            labelArray_3030[j_3030 + 1]
                    .setBackground(Color.RED);

            stepLog_3030.append("Langkah ")
                    .append(stepCount_3030)
                    .append(": Menukar elemen ke-")
                    .append(j_3030)
                    .append(" dan ke-")
                    .append(j_3030 + 1)
                    .append("\n");

        } else {

            stepLog_3030.append("Langkah ")
                    .append(stepCount_3030)
                    .append(": Tidak ada pertukaran\n");
        }

        stepLog_3030.append("Hasil : ")
                .append(arrayToString_3030(array_3030))
                .append("\n\n");

        stepArea_3030.append(
                stepLog_3030.toString());

        updateLabels_3030();

        j_3030++;

        if (j_3030 >=
                array_3030.length - i_3030 - 1) {

            j_3030 = 0;
            i_3030++;
        }

        stepCount_3030++;

        if (i_3030 >= array_3030.length - 1) {

            sorting_3030 = false;
            stepButton_3030.setEnabled(false);

            JOptionPane.showMessageDialog(
                    this,
                    "Sorting selesai!");
        }
    }

    private void updateLabels_3030() {

        for (int k_3030 = 0;
             k_3030 < array_3030.length;
             k_3030++) {

            labelArray_3030[k_3030]
                    .setText(
                            String.valueOf(
                                    array_3030[k_3030]));
        }
    }

    private void resetHighlights_3030() {

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

        sorting_3030 = false;
        i_3030 = 0;
        j_3030 = 0;
        stepCount_3030 = 1;
    }

    private String arrayToString_3030(
            int[] arr_3030) {

        StringBuilder sb_3030 =
                new StringBuilder();

        for (int k_3030 = 0;
             k_3030 < arr_3030.length;
             k_3030++) {

            sb_3030.append(arr_3030[k_3030]);

            if (k_3030 < arr_3030.length - 1) {
                sb_3030.append(", ");
            }
        }

        return sb_3030.toString();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            BubbleSortGUI_2511533030 gui_3030 =
                    new BubbleSortGUI_2511533030();

            gui_3030.setVisible(true);
        });
    }
}