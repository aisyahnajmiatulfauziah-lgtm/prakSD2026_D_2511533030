package pekan9_2511533030;

public class BTreeDriver_2511533030 {
    public static void main(String[] args) {
        // Membuat pohon
        BTree_2511533030 tree_3030 = new BTree_2511533030();
        System.out.print("Jumlah Simpul awal pohon: ");
        System.out.println(tree_3030.countNodes_3030());

        // Menambahkan simpul data 1
        Node_2511533030 root_3030 = new Node_2511533030(1);

        // Menjadikan simpul 1 sebagai root
        tree_3030.setRoot_3030(root_3030);
        System.out.println("Jumlah simpul jika hanya ada root: ");
        System.out.println(tree_3030.countNodes_3030());

        Node_2511533030 node2 = new Node_2511533030(2);
        Node_2511533030 node3 = new Node_2511533030(3);
        Node_2511533030 node4 = new Node_2511533030(4);
        Node_2511533030 node5 = new Node_2511533030(5);
        Node_2511533030 node6 = new Node_2511533030(6);
        Node_2511533030 node7 = new Node_2511533030(7);
        Node_2511533030 node8 = new Node_2511533030(8);
        Node_2511533030 node9 = new Node_2511533030(9);

        root_3030.setLeft_3030(node2);
        node2.setLeft_3030(node4);
        node2.setRight_3030(node5);
        node4.setRight_3030(node8);
        root_3030.setRight_3030(node3);
        node3.setLeft_3030(node6);
        node3.setRight_3030(node7);
        node6.setLeft_3030(node9);

        // Set root
        tree_3030.setCurrent_3030(tree_3030.getRoot_3030());
        System.out.println("Menampilkan simpul terakhir: ");
        System.out.println(tree_3030.getCurrent_3030().getData_3030());

        System.out.println("Jumlah simpul setelah simpul 7 ditambahkan");
        System.out.println(tree_3030.countNodes_3030());

        System.out.println("InOrder: ");
        tree_3030.printInorder_3030();

        System.out.println("\nPreorder: ");
        tree_3030.printPreorder_3030();

        System.out.println("\nPostorder: ");
        tree_3030.printPostorder_3030();

        System.out.println("\nMenampilkan simpul dalam bentuk pohon");
        tree_3030.print_3030();
    }
}