package pekan9_2511533030;

public class BTree_2511533030 {
    private Node_2511533030 root_3030;
    private Node_2511533030 currentNode_3030;

    public BTree_2511533030() {
        root_3030 = null;
    }

    public boolean search_3030(int data_3030) {
        return search_3030(root_3030, data_3030);
    }

    private boolean search_3030(Node_2511533030 node_3030, int data_3030) {
        if (node_3030.getData_3030() == data_3030)
            return true;

        if (node_3030.getLeft_3030() != null)
            if (search_3030(node_3030.getLeft_3030(), data_3030))
                return true;

        if (node_3030.getRight_3030() != null)
            if (search_3030(node_3030.getRight_3030(), data_3030))
                return true;

        return false;
    }

    public void printInorder_3030() {
        root_3030.printInorder_3030(root_3030);
    }

    public void printPreorder_3030() {
        root_3030.printPreorder_3030(root_3030);
    }

    public void printPostorder_3030() {
        root_3030.printPostorder_3030(root_3030);
    }

    public Node_2511533030 getRoot_3030() {
        return root_3030;
    }

    public boolean isEmpty() {
        return root_3030 == null;
    }

    public int countNodes_3030() {
        return countNodes_3030(root_3030);
    }

    private int countNodes_3030(Node_2511533030 node_3030) {
        int count_3030 = 1;

        if (node_3030 == null) {
            return 0;
        } else {
            count_3030 += countNodes_3030(node_3030.getLeft_3030());
            count_3030 += countNodes_3030(node_3030.getRight_3030());
            return count_3030;
        }
    }

    public void print_3030() {
        root_3030.print();
    }

    public Node_2511533030 getCurrent_3030() {
        return currentNode_3030;
    }

    public void setCurrent_3030(Node_2511533030 node_3030) {
        this.currentNode_3030 = node_3030;
    }

    public void setRoot_3030(Node_2511533030 root_3030) {
        this.root_3030 = root_3030;
    }
}