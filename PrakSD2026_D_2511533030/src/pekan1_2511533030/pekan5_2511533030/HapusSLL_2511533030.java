package pekan5_2511533030;

public class HapusSLL_2511533030 {
    // fungsi untuk menghapus head
    public static NodeSLL_2511533030 deleteHead_3014(NodeSLL_2511533030 head_3030) {
        // jika SLL kosong 
        if (head_3030 == null) {
            return null;
        }
        // pindahkan head ke node berikutnya 
        head_3030 = head_3030.next_3030;
        // return head baru 
        return head_3030;
    }

    // fungsi menghapus node terakhir SLL
    public static NodeSLL_2511533030 removeLastNode_3014(NodeSLL_2511533030 head_3030) {
        // jika list kosong , return null 
        if (head_3030 == null) {
            return null;
        }
        // jika list satu node , hapus node dan return null
        if (head_3030.next_3030 == null) {
            return null;
        }
        // temukan node terakhir kedua 
        NodeSLL_2511533030 secondLast = head_3030;
        while (secondLast.next_3030.next_3030 != null) {
            secondLast = secondLast.next_3030;
        }
        // hapus node terakhir 
        secondLast.next_3030 = null;
        return head_3030;
    }

    // fungsi menghapus node di posisi tertentu
    public static NodeSLL_2511533030 deleteNode_3014(NodeSLL_2511533030 head_3030, int position_3030) {
        NodeSLL_2511533030 temp_3030 = head_3030;
        NodeSLL_2511533030 prev_3030 = null;

        // jika linked list null
        if (temp_3030 == null)
            return head_3030;

        // kasus 1: head dihapus
        if (position_3030 == 1) {
            head_3030 = temp_3030.next_3030;
            return head_3030;
        }

        // kasus 2: menghapus node di tengah
        for (int i_3030 = 1; temp_3030 != null && i_3030 < position_3030; i_3030++) {
            prev_3030 = temp_3030;
            temp_3030 = temp_3030.next_3030;
        }

        // jika ditemukan, hapus node
        if (temp_3030 != null) {
            prev_3030.next_3030 = temp_3030.next_3030;
        } else {
            System.out.println("Data tidak ada");
        }
        return head_3030;
    }

    // fungsi mencetak SLL
    public static void printList_3030(NodeSLL_2511533030 head_3030) {
        NodeSLL_2511533030 curr_3030 = head_3030;
        while (curr_3030.next_3030 != null) {
            System.out.print(curr_3030.data_3030 + "-->");
            curr_3030 = curr_3030.next_3030;
        }
        System.out.print(curr_3030.data_3030);
        System.out.println();
    }

    // kelas main
    public static void main(String[] args) {
        // buat SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        NodeSLL_2511533030 head_3030 = new NodeSLL_2511533030(1);
        head_3030.next_3030 = new NodeSLL_2511533030(2);
        head_3030.next_3030.next_3030 = new NodeSLL_2511533030(3);
        head_3030.next_3030.next_3030.next_3030 = new NodeSLL_2511533030(4);
        head_3030.next_3030.next_3030.next_3030.next_3030 = new NodeSLL_2511533030(5);
        head_3030.next_3030.next_3030.next_3030.next_3030.next_3030 = new NodeSLL_2511533030(6);

        // cetak list awal
        System.out.println("List awal: ");
        printList_3030(head_3030);

        // hapus head
        head_3030 = deleteHead_3014(head_3030);
        System.out.println("List setelah head dihapus: ");
        printList_3030(head_3030);

        // hapus node terakhir
        head_3030 = removeLastNode_3014(head_3030);
        System.out.println("List setelah simpul terakhir dihapus: ");
        printList_3030(head_3030);

        // hapus node di posisi 2
        int position_3030 = 2;
        head_3030 = deleteNode_3014(head_3030, position_3030);
        System.out.println("List setelah posisi 2 dihapus: ");
        printList_3030(head_3030);
    }
}