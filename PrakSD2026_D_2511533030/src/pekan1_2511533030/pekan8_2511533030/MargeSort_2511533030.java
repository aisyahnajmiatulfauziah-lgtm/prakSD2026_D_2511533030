package pekan8_2511533030;

public class MargeSort_2511533030 {
	    void merge_3030(int arr_3030[], int l_3030, int m_3030, int r_3030) {
	        // Find sizes of two subarrays to be merged
	        int n1_3030 = m_3030 - l_3030 + 1;
	        int n2_3030 = r_3030 - m_3030;
	        /* Create temp arrays */
	        int L_3030[] = new int[n1_3030];
	        int R_3030[] = new int[n2_3030];
	        /* Copy data to temp arrays */
	        for (int i_3030 = 0; i_3030 < n1_3030; ++i_3030)
	            L_3030[i_3030] = arr_3030[l_3030 + i_3030];
	        for (int j_3030 = 0; j_3030 < n2_3030; ++j_3030)
	            R_3030[j_3030] = arr_3030[m_3030 + 1 + j_3030];
	        int i_3030 = 0, j_3030 = 0;
	        // Initial index of merged subarray array
	        int k_3030 = l_3030;
	        while (i_3030 < n1_3030 && j_3030 < n2_3030) {
	            if (L_3030[i_3030] <= R_3030[j_3030]) {
	                arr_3030[k_3030] = L_3030[i_3030];
	                i_3030++;
	            } else {
	                arr_3030[k_3030] = R_3030[j_3030];
	                j_3030++;
	            }
	            k_3030++;
	        }
	        /* Copy remaining elements of L[] if any */
	        while (i_3030 < n1_3030) {
	            arr_3030[k_3030] = L_3030[i_3030];
	            i_3030++;
	            k_3030++;
	        }
	        /* Copy remaining elements of R[] if any */
	        while (j_3030 < n2_3030) {
	            arr_3030[k_3030] = R_3030[j_3030];
	            j_3030++;
	            k_3030++;
	        }
	    }

void sort_3030(int arr_3030[], int l_3030, int r_3030) {
    if (l_3030 < r_3030) {
        // Find the middle point
        int m_3030 = (l_3030 + r_3030) / 2;
        // Sort first and second halves
        sort_3030(arr_3030, l_3030, m_3030);
        sort_3030(arr_3030, m_3030 + 1, r_3030);
        // Merge the sorted halves
        merge_3030(arr_3030, l_3030, m_3030, r_3030);
    }
}
/* A utility function to print array of size n */
static void printArray_3030(int arr_3030[]) {
    int n_3030 = arr_3030.length;
    for (int i_3030 = 0; i_3030 < n_3030; ++i_3030)
        System.out.print(arr_3030[i_3030] + " ");
    System.out.println();
}
public static void main(String args[]) {
    int arr_3030[] = { 12, 11, 13, 5, 6, 7 };

    System.out.println("Sebelum terurut");
    printArray_3030(arr_3030);

    MargeSort_2511533030 ob = new MargeSort_2511533030();
    ob.sort_3030(arr_3030, 0, arr_3030.length - 1);

    System.out.println("\nSesudah Terurut menggunakan merge Sort");
    printArray_3030(arr_3030);
}
}


