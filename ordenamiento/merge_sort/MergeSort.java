package ordenamiento.merge_sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Antes del ordenamiento:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Después del ordenamiento:");
        printArray(arr);
    }

    // Función principal de Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 1. Dividir
            int mid = (left + right) / 2;

            // 2. Ordenar cada mitad
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // 3. Fusionar
            merge(arr, left, mid, right);
        }
    }

    // Función para fusionar dos subarreglos
    public static void merge(int[] arr, int left, int mid, int right) {
        // Tamaños de los subarreglos
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Subarreglos temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copiar datos
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Fusionar los subarreglos
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copiar los elementos restantes
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // Método para imprimir el arreglo
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
