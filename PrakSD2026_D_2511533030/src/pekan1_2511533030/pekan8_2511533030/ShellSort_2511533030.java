package pekan8_2511533030;

public class ShellSort_2511533030 {
	public static void ShellSort_2511533030(int[] A) {
		int n_3030 = A.length;
		int gap_3030 = n_3030 / 2;
		while (gap_3030 > 0) {
			for (int i_3030 = gap_3030; i_3030 < n_3030; i_3030++) {
				int temp_3030 = A[i_3030];
				int j_3030 = i_3030;
				while (j_3030 >= gap_3030 && A[j_3030 - gap_3030] > temp_3030) {
					A[j_3030] = A[j_3030 - gap_3030];
					j_3030 = j_3030 - gap_3030;
				}
				A[j_3030] = temp_3030;
			}
			gap_3030 = gap_3030 / 2;
		}
	}
	
	public static void maain (String[] args) {
		int[] data = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
		
		System.out.print("Sebelum: ");
		printArray(data);
		
		ShellSort_2511533030(data);
		
		System.out.print("Sesudah (Shell Sort) : ");
		printArray(data);
		
	}
	
	public static void printArray(int[] arr_3030) {
		for (int i_3030 : arr_3030) System.out.print(i_3030 + " ");
		System.out.println();
	}
		
	}
