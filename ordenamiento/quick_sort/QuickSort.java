package ordenamiento.quick_sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Antes del ordenamiento:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Después del ordenamiento:");
        printArray(arr);
    }

    // Función principal de Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Particiona el arreglo y obtiene el índice del pivote
            int pi = partition(arr, low, high);

            // Ordenar recursivamente los subarreglos
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Función para particionar el arreglo
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivote
        int i = low - 1;         // Índice del menor elemento

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Intercambio arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Colocar el pivote en su posición correcta
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Método para imprimir el arreglo
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}