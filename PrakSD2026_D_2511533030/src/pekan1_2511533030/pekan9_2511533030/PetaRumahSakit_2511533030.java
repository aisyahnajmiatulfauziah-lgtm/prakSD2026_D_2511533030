package pekan9_2511533030;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class PetaRumahSakit_2511533030 extends JFrame {
    static Map<String, ArrayList<String>> graph_3030 = new LinkedHashMap<>();
    static Map<String, Point> pos_3030 = new HashMap<>();
    String[] lokasi_3030 = {
            "Parkir",
            "Lobby",
            "IGD",
            "Farmasi",
            "Radiologi",
            "Laboratorium",
            "Poli Umum",
            "Poli Gigi",
            "Ruang Inap",
            "ICU",
            "Kantin",
            "Masjid"
    };
    Set<String> visited_3030 = new LinkedHashSet<>();
    ArrayList<String> path_3030 = new ArrayList<>();
    String start_3030 = "";
    String goal_3030 = "";
    String metode_3030 = "";
    JComboBox<String> cbStart_3030;
    JComboBox<String> cbGoal_3030;
    JTextArea hasil_3030;
    JPanel graphPanel_3030 = new JPanel() {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            displayGraph_3030((Graphics2D) g);
        }
    };
    public PetaRumahSakit_2511533030() {
        setTitle("Pencarian Jalur Rumah Sakit Menggunakan BFS dan DFS");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buatGraph_3030();
        buatGUI_3030();
        setVisible(true);
    }
    void buatGraph_3030() {
        for (String s : lokasi_3030) {
            graph_3030.put(s, new ArrayList<>());
        }
        tambahEdge_3030("Parkir", "Lobby");
        tambahEdge_3030("Lobby", "IGD");
        tambahEdge_3030("Lobby", "Farmasi");
        tambahEdge_3030("Lobby", "Poli Umum");
        tambahEdge_3030("IGD", "ICU");
        tambahEdge_3030("IGD", "Laboratorium");
        tambahEdge_3030("Farmasi", "Kantin");
        tambahEdge_3030("Farmasi", "Ruang Inap");
        tambahEdge_3030("Poli Umum", "Laboratorium");
        tambahEdge_3030("Poli Umum", "Poli Gigi");
        tambahEdge_3030("Poli Gigi", "Radiologi");
        tambahEdge_3030("Laboratorium", "Radiologi");
        tambahEdge_3030("Radiologi", "Ruang Inap");
        tambahEdge_3030("ICU", "Ruang Inap");
        tambahEdge_3030("Ruang Inap", "Masjid");
        tambahEdge_3030("Kantin", "Masjid");
        tambahEdge_3030("Poli Umum", "Farmasi");
        pos_3030.put("Parkir", new Point(400, 60));
        pos_3030.put("Lobby", new Point(400, 140));
        pos_3030.put("IGD", new Point(180, 240));
        pos_3030.put("Farmasi", new Point(400, 240));
        pos_3030.put("Poli Umum", new Point(620, 240));
        pos_3030.put("Laboratorium", new Point(180, 360));
        pos_3030.put("Radiologi", new Point(400, 360));
        pos_3030.put("Poli Gigi", new Point(620, 360));
        pos_3030.put("ICU", new Point(180, 500));
        pos_3030.put("Ruang Inap", new Point(400, 500));
        pos_3030.put("Kantin", new Point(620, 500));
        pos_3030.put("Masjid", new Point(400, 620));
    }
    void tambahEdge_3030(String a, String b) {
        graph_3030.get(a).add(b);
        graph_3030.get(b).add(a);
    }
    void buatGUI_3030() {
        JPanel atas = new JPanel();
        cbStart_3030 = new JComboBox<>(lokasi_3030);
        cbGoal_3030 = new JComboBox<>(lokasi_3030);
        JButton bfs = new JButton("BFS");
        JButton dfs = new JButton("DFS");
        JButton reset = new JButton("RESET");
        atas.add(new JLabel("Start"));
        atas.add(cbStart_3030);
        atas.add(new JLabel("Goal"));
        atas.add(cbGoal_3030);
        atas.add(bfs);
        atas.add(dfs);
        atas.add(reset);
        add(atas, BorderLayout.NORTH);
        graphPanel_3030.setBackground(Color.WHITE);
        add(graphPanel_3030, BorderLayout.CENTER);
        hasil_3030 = new JTextArea(6, 20);
        hasil_3030.setEditable(false);
        hasil_3030.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(hasil_3030), BorderLayout.SOUTH);
        bfs.addActionListener(e -> BFS_3030());
        dfs.addActionListener(e -> DFS_3030());
        reset.addActionListener(e -> resetGraph_3030());
    }
    void BFS_3030() {
        visited_3030.clear();
        path_3030.clear();
        metode_3030 = "BFS";
        start_3030 = cbStart_3030.getSelectedItem().toString();
        goal_3030 = cbGoal_3030.getSelectedItem().toString();
        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        q.add(start_3030);
        visited_3030.add(start_3030);
        parent.put(start_3030, null);
        boolean found = false;
        while (!q.isEmpty()) {
            String current = q.poll();
            if (current.equals(goal_3030)) {
                found = true;
                break;
            }
            for (String next : graph_3030.get(current)) {
                if (!visited_3030.contains(next)) {
                    visited_3030.add(next);
                    parent.put(next, current);
                    q.add(next);
                }
            }
        }

        if (found) {
            String temp = goal_3030;
            while (temp != null) {
                path_3030.add(0, temp);
                temp = parent.get(temp);
            }
        }
        displayPath_3030();
    }
    void DFS_3030() {
        visited_3030.clear();
        path_3030.clear();
        metode_3030 = "DFS";
        start_3030 = cbStart_3030.getSelectedItem().toString();
        goal_3030 = cbGoal_3030.getSelectedItem().toString();
        dfsRekursif_3030(start_3030);
        displayPath_3030();
    }
    boolean dfsRekursif_3030(String node) {
        visited_3030.add(node);
        path_3030.add(node);
        if (node.equals(goal_3030)) {
            return true;
        }
        for (String next : graph_3030.get(node)) {
            if (!visited_3030.contains(next)) {
                if (dfsRekursif_3030(next)) {
                    return true;
                }
            }
        }

        path_3030.remove(path_3030.size() - 1);
        return false;
    }
    void displayPath_3030() {
        hasil_3030.setText(
                "Metode : " + metode_3030 +
                "\nJalur : " + path_3030 +
                "\nNode Dikunjungi : " + visited_3030 +
                "\nJumlah Node Dieksplorasi : " + visited_3030.size()
        );
        graphPanel_3030.repaint();
    }
    void resetGraph_3030() {
        visited_3030.clear();
        path_3030.clear();
        hasil_3030.setText("");
        graphPanel_3030.repaint();
    }
    void displayGraph_3030(Graphics2D g_3030) {
        g_3030.setStroke(new BasicStroke(2));
        for (String a_3030 : graph_3030.keySet()) {
            for (String b_3030 : graph_3030.get(a_3030)) {
                if (a_3030.compareTo(b_3030) < 0) {
                    Point p1_3030 = pos_3030.get(a_3030);
                    Point p2_3030 = pos_3030.get(b_3030);
                    g_3030.setColor(Color.GRAY);
                    g_3030.drawLine(p1_3030.x, p1_3030.y, p2_3030.x, p2_3030.y);
                }
            }
        }
        for (String node_3030 : lokasi_3030) {
            Point p_3030 = pos_3030.get(node_3030);
            if (node_3030.equals(start_3030))
                g_3030.setColor(Color.GREEN);
            else if (node_3030.equals(goal_3030))
                g_3030.setColor(Color.RED);
            else if (path_3030.contains(node_3030))
                g_3030.setColor(Color.YELLOW);
            else if (visited_3030.contains(node_3030))
                g_3030.setColor(Color.CYAN);
            else
                g_3030.setColor(Color.LIGHT_GRAY);
            g_3030.fillOval(p_3030.x - 25, p_3030.y - 25, 50, 50);
            g_3030.setColor(Color.BLACK);
            g_3030.drawOval(p_3030.x - 25, p_3030.y - 25, 50, 50);
            g_3030.setFont(new Font("Arial", Font.BOLD, 11));
            g_3030.drawString(node_3030, p_3030.x - 30, p_3030.y - 30);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetaRumahSakit_2511533030();
        });
    }
}
