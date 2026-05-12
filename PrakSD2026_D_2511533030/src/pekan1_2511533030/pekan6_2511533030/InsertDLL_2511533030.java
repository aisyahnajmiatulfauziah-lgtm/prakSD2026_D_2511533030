package pekan6_2511533030;
public class InsertDLL_2511533030 {
	// menambahkan node di awal DLL
	static NodeDLL_2511533030 insertBegin(NodeDLL_2511533030 head_3030, int data_3030) {
		// buat node baru
		NodeDLL_2511533030 new_node = new NodeDLL_2511533030(data_3030);
		// jadikan pointer next nya head
		new_node.next_3030 = head_3030;
		// jadikan pointer prev head ke new_node 
		if (head_3030 != null) {
			head_3030.prev_3030 = new_node;
		}
		return new_node;
	}
	// fungsi menambahkan node di akhir
public static NodeDLL_2511533030 insertEnd(NodeDLL_2511533030 head_3030, int newData_3030) {
	// buat node baru
	NodeDLL_2511533030 newNode = new NodeDLL_2511533030(newData_3030);
	// jika dll null jadikan head
	if (head_3030 == null) {
		head_3030 = newNode;
	}
	else {
		NodeDLL_2511533030 curr_3030 = head_3030;
		while (curr_3030.next_3030 != null) {
			curr_3030 = curr_3030.next_3030;
		}
		curr_3030.next_3030 = newNode;
		newNode.prev_3030 = curr_3030;
	}
	return head_3030;
	}
	// fungsi menambahkan node di posisi tertentu
	public static NodeDLL_2511533030 insertAtPosition(NodeDLL_2511533030 head_3030, int pos_3030, int new_data_3030) {
		// buat node baru
		NodeDLL_2511533030 new_node = new NodeDLL_2511533030(new_data_3030);
		if (pos_3030 == 1) {
			new_node.next_3030 = head_3030;
			if (head_3030 != null) {
				head_3030.prev_3030 = new_node; }
			head_3030 = new_node;
			return head_3030; }
		NodeDLL_2511533030 curr_3030 = head_3030;
	for (int i_3030 = 1; i_3030 < pos_3030 - 1 && curr_3030 != null; ++i_3030) {
			curr_3030 = curr_3030.next_3030; }
		if (curr_3030 == null) {
			System.out.println("Posisi tidak ada");
			return head_3030; }
		new_node.prev_3030 = curr_3030;
		new_node.next_3030 = curr_3030.next_3030;
		curr_3030.next_3030 = new_node;
		if (new_node.next_3030 != null) {
			new_node.next_3030.prev_3030 = new_node; }
		return head_3030;  
		}
		public static void printList(NodeDLL_2511533030 head_3030) {
			NodeDLL_2511533030 curr_3030 = head_3030;
			while (curr_3030 != null) {
				System.out.print(curr_3030.data_3030 + " <-> ");
				curr_3030 = curr_3030.next_3030;
			}
			System.out.println();
		}
		
		public static void main(String[] args) {
			// membuat dll 2 <-> 3 <-> 5
			NodeDLL_2511533030 head_3030 = new NodeDLL_2511533030(2);
			head_3030.next_3030 = new NodeDLL_2511533030(3);
			head_3030.next_3030.prev_3030 = head_3030;
			head_3030.next_3030.next_3030 = new NodeDLL_2511533030(5);
			head_3030.next_3030.next_3030.prev_3030 = head_3030.next_3030;
			// cetak DLL awal
			System.out.print("DLL Awal: ");
			printList(head_3030);
			// tambah 1 di awal
			head_3030 = insertBegin(head_3030, 1);
			System.out.print(
					"simpul 1 ditambah di awal: ");
				printList(head_3030);
			// tambah 6 di akhir 
			System.out.print(
					"simpul 6 ditambah di akhir:");
			int data_3030 = 6;
			head_3030 = insertEnd(head_3030, data_3030);
			printList(head_3030);
			// menambah node 4 di posisi 4
			System.out.print("tambah node 4 di posisi 4: ");
			int data2_3030 = 4;
			int pos_3030 = 4;
			head_3030 = insertAtPosition(head_3030, pos_3030, data2_3030);
			printList(head_3030);
		}
	}
