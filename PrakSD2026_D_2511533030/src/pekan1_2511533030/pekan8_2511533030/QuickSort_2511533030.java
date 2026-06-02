package pekan8_2511533030;

public class QuickSort_2511533030 {
	static void swap_3030(int[] arr_3030, int i_3030, int j_3030) {
		int temp_3030 = arr_3030[i_3030];
		arr_3030[i_3030] = arr_3030[j_3030];
		arr_3030[j_3030] = temp_3030;
	}
	
	// Metode tambahan untuk mengatur pivot menggunakan Median-of-Three
	static void medianOfThree_3030(int[] arr_3030, int low_3030, int high_3030) {
		int mid_3030 = low_3030 + (high_3030 - low_3030) / 2;
		
		// Urutkan elemen low, mid, dan high
		if (arr_3030[low_3030] > arr_3030[mid_3030]) {
			swap_3030(arr_3030, low_3030, mid_3030);
		}
		if (arr_3030[low_3030] > arr_3030[high_3030]) {
			swap_3030(arr_3030, low_3030, high_3030);
		}
		if (arr_3030[mid_3030] > arr_3030[high_3030]) {
			swap_3030(arr_3030, mid_3030, high_3030);
		}
		swap_3030(arr_3030, mid_3030, high_3030);
	}
	
	static int partition_3030(int[] arr_3030, int low_3030, int high_3030) {
		// Panggil fungsi medianOfThree sebelum menentukan pivot
		medianOfThree_3030 (arr_3030, low_3030, high_3030);
		int pivot_3030 = arr_3030[high_3030]; // Sekarang arr[high] sudah berisi nilai median
		int i_3030 = (low_3030 - 1);
		
		for (int j_3030 = low_3030; j_3030 <= high_3030 - 1; j_3030++) {
			// Jika elemen saat ini lebih kecil dari atau sama dengan pivot
			if (arr_3030[j_3030] < pivot_3030) {
				// Increment indeks elemen yang lebih kecil
				i_3030++;
				swap_3030(arr_3030, i_3030, j_3030);
			}
		}
		swap_3030(arr_3030, i_3030 + 1, high_3030);
		return (i_3030 + 1);
	}
	
	static void quickSort_3030(int[] arr_3030, int low_3030, int high_3030) {
		if (low_3030 < high_3030) {
			int pi_3030 = partition_3030(arr_3030, low_3030, high_3030);
			quickSort_3030(arr_3030, low_3030, pi_3030 - 1);
			quickSort_3030(arr_3030, pi_3030 + 1, high_3030);
		}
	}
	
	public static void printArr_3030(int[] arr_3030) {
		for (int i_3030 = 0; i_3030 < arr_3030.length; i_3030++) {
			System.out.print(arr_3030[i_3030] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr_3030 = {10, 7, 8, 9, 1, 5};
		int N_3030 = arr_3030.length;
		System.out.print("data sebelum diurutkan: ");
		printArr_3030(arr_3030);
		
		quickSort_3030(arr_3030, 0, N_3030 - 1);
		
		System.out.print("data terurut quicksort: ");
		printArr_3030(arr_3030);
	}
}