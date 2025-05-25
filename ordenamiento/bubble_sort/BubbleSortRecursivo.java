public class BubbleSortRecursivo {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        System.out.println("Antes del ordenamiento:");
        printArray(arr);

        bubbleSortRecursive(arr, arr.length);

        System.out.println("Después del ordenamiento:");
        printArray(arr);
    }

    // Método de Bubble Sort recursivo
    public static void bubbleSortRecursive(int[] arr, int n) {
        // Caso base
        if (n == 1) return;

        // Una pasada del algoritmo
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Intercambio
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Llamada recursiva para el resto del arreglo
        bubbleSortRecursive(arr, n - 1);
    }

    // Método para imprimir el arreglo
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}