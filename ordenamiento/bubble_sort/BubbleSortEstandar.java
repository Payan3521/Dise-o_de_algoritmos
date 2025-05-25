public class BubbleSortEstandar {

    // Método principal para probar
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("Antes del ordenamiento:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Después del ordenamiento:");
        printArray(arr);
    }

    // Método de ordenamiento Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambio
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // Si no hubo intercambios, la lista ya está ordenada
            if (!swapped) break;
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
