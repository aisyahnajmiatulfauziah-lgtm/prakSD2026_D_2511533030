package pekan7_2511533030;

public class BubleSort_2511533030 {
	public static void bubbleSort(int[] arr_3030) {
		int n_3030 = arr_3030.length;
		for (int i_3030 = 0; i_3030 < n_3030; i_3030++) {
			for (int j_3030 = 0; j_3030 < n_3030 - i_3030 - 1; j_3030++) {
				if (arr_3030[j_3030] > arr_3030[j_3030 + 1]) {
					int temp_3030 = arr_3030[j_3030];
					arr_3030[j_3030] = arr_3030[j_3030 + 1];
					arr_3030[j_3030 + 1] = temp_3030;
				// System.out.println("data:"+arr[j]+" "+arr[j+1]);
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr_3030[] = { 23, 78, 45, 8, 32, 56, 1 };
		int n_3030 = arr_3030.length;
		System.out.print("array yang belum terurut: ");
		for (int i_3030 = 0; i_3030 < n_3030; i_3030++)
			System.out.print(arr_3030[i_3030] + " ");
		System.out.println (""); 
		bubbleSort(arr_3030);
		System.out.print("array yang terurut menggunakan BubbleSort: ");
		for (int i_3030 = 0; i_3030 < n_3030; i_3030++)
			System.out.print(arr_3030[i_3030] + " ");
		System.out.println("");
	}


}
