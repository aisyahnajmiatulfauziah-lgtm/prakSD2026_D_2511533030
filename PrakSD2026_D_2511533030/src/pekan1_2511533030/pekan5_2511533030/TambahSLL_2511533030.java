package pekan5_2511533030;

public class TambahSLL_2511533030 {
		public static NodeSLL_2511533030 insertAtFront_3030 (NodeSLL_2511533030 head_3030, int value_3030) {
			NodeSLL_2511533030 new_node = new NodeSLL_2511533030 (value_3030);
			new_node.next_3030 = head_3030;
			return new_node;
		}
		// fungsi menambahkan node di akhir SLL
		public static NodeSLL_2511533030 insertAtEnd_3030 (NodeSLL_2511533030 head_3030, int value_3030) {
			// buat sebuah node dengan sebuah nilai
			NodeSLL_2511533030 newNode = new NodeSLL_2511533030 (value_3030);
			// jika list kosong maka node jadi head
			if (head_3030 == null) {
				return newNode;
			}
			// Simpan head ke variabel sementara
			NodeSLL_2511533030 last = head_3030;
			// telusuri ke node akhir
			while (last.next_3030 != null) {
				last = last.next_3030;
			}
			// ubah pointer
			last.next_3030 = newNode;
			return head_3030;
		}
		static NodeSLL_2511533030 GetNode (int data_3014) {
			return new NodeSLL_2511533030 (data_3014);
		}
		
		static NodeSLL_2511533030 insertPos (NodeSLL_2511533030 headNode, int position_3030, int value_3030) {
			NodeSLL_2511533030 head_3030 = headNode;
			if (position_3030 < 1)
				System.out.print ("Invalid position");
			if (position_3030 == 1) {
				NodeSLL_2511533030 new_node = new NodeSLL_2511533030(value_3030);
				new_node.next_3030 = head_3030;
				return new_node;	
			} else {
				while (position_3030-- != 0) {
					if (position_3030 == 1) {
						NodeSLL_2511533030 newNode = GetNode (value_3030);
						newNode.next_3030 = headNode.next_3030;
						headNode.next_3030 = newNode;
						break;
					}
					headNode = headNode.next_3030;
				}
				if (position_3030 != 1)
			System.out.print("Posisi di luar jangkauan");          
			return head_3030;    }  }  
		public static void printList_3014 (NodeSLL_2511533030 head_3030) {
			NodeSLL_2511533030 curr_3030 = head_3030;
		 while (curr_3030.next_3030 != null) {
			 System.out.print(curr_3030.data_3030+"-->");
			 curr_3030 = curr_3030.next_3030;
		 }
		 if (curr_3030.next_3030==null) {
			 System.out.print(curr_3030.data_3030);  }
		 System.out.println();
		 }
			
		public static void main (String[] args) {
			// buat linked list 2->3->5->6
			NodeSLL_2511533030 head_3030 = new NodeSLL_2511533030(2);
			head_3030.next_3030 = new NodeSLL_2511533030(3);
			head_3030.next_3030.next_3030 = new NodeSLL_2511533030(5);
			head_3030.next_3030.next_3030.next_3030 = new NodeSLL_2511533030(6);
			// cetak list asli
			System.out.print("Senarai berantai awal:");
			printList_3014 (head_3030);
			// tambahkan node baru didepan
			System.out.print("tambah 1 simpul di depan: ");
			int data_3030 = 1;
			head_3030 = insertAtFront_3030(head_3030, data_3030);
			// cetak update list
			printList_3014(head_3030);
			// tambahkan node baru dibelakang
			System.out.print("tambah 1 simpul di belakang");
			int data2 = 7;
			head_3030 = insertAtEnd_3030 (head_3030, data2);
			// cetak update list
			printList_3014 (head_3030);
			System.out.print("tambah 1 simpul ke data 4: ");
			int data3 = 4;
			int pos=4;
			head_3030 = insertPos (head_3030,pos,data3);
			// cetak update list
			printList_3014 (head_3030);
			
		}
			
	}


