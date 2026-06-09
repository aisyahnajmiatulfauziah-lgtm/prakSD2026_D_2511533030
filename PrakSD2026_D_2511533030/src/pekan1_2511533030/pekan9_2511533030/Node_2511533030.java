package pekan9_2511533030;

public class Node_2511533030 {
    int data_3030;
    Node_2511533030 left_3030;
    Node_2511533030 right_3030;

    public Node_2511533030(int data_3030) {
        this.data_3030 = data_3030;
        left_3030 = null;
        right_3030 = null;
    }

    public void setLeft_3030(Node_2511533030 node_3030) {
        if (left_3030 == null)
            left_3030 = node_3030;
    }

    public void setRight_3030(Node_2511533030 node_3030) {
        if (right_3030 == null)
            right_3030 = node_3030;
    }

    public Node_2511533030 getLeft_3030() {
        return left_3030;
    }

    public Node_2511533030 getRight_3030() {
        return right_3030;
    }

    public int getData_3030() {
        return data_3030;
    }

    public void setData_3030(int data_3030) {
        this.data_3030 = data_3030;
    }

    void printPreorder_3030(Node_2511533030 node_3030) {
        if (node_3030 == null)
            return;

        System.out.print(node_3030.data_3030 + " ");
        printPreorder_3030(node_3030.left_3030);
        printPreorder_3030(node_3030.right_3030);
    }

    void printPostorder_3030(Node_2511533030 node_3030) {
        if (node_3030 == null)
            return;

        printPostorder_3030(node_3030.left_3030);
        printPostorder_3030(node_3030.right_3030);
        System.out.print(node_3030.data_3030 + " ");
    }

    void printInorder_3030(Node_2511533030 node_3030) {
        if (node_3030 == null)
            return;

        printInorder_3030(node_3030.left_3030);
        System.out.print(node_3030.data_3030 + " ");
        printInorder_3030(node_3030.right_3030);
    }

    public String print() {
        return this.print("", true, "");
    }

    public String print(String prefix_3030, boolean isTail_3030, String sb_3030) {
        if (right_3030 != null) {
            right_3030.print(prefix_3030 + (isTail_3030 ? "|  " : "   "), false, sb_3030);
        }

        System.out.println(prefix_3030 + (isTail_3030 ? "\\-- " : "/--") + data_3030);

        if (left_3030 != null) {
            left_3030.print(prefix_3030 + (isTail_3030 ? "   " : "|   "), true, sb_3030);
        }

        return sb_3030;
    }
}