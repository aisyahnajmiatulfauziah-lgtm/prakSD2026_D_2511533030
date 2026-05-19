package pekan7_2511533030;

public class InsertionSort_2511533030 {
	public static void insertionSort(int[] arr_3030) {
		int n_3030 = arr_3030.length;
		for (int i_3030 = 1; i_3030 < n_3030; i_3030++) {
			int key_3030 = arr_3030[i_3030];
			int j_3030 = i_3030 - 1;
			while (j_3030 >= 0 && arr_3030[j_3030] > key_3030) {
				arr_3030[j_3030 + 1] = arr_3030[j_3030];
				j_3030--;
			}
			arr_3030[j_3030 + 1] = key_3030;
		}
		
	}
	public static void main(String[] args) {
		int arr_3030 [] = { 23, 78, 45, 8, 32, 56, 1 };
		int n_3030 = arr_3030.length;
		System.out.printf("array yang belum terurut:\n");
		for (int i_3030 = 0; i_3030 < n_3030; i_3030++)
			System.out.print(arr_3030[i_3030] + " ");
		System.out.println("");
		insertionSort(arr_3030);
		System.out.printf("array yang terurut:\n");
		for (int i_3030 = 0; i_3030 < n_3030; i_3030++)
			System.out.print(arr_3030[i_3030] + " ");
		System.out.println("");
	}

}
