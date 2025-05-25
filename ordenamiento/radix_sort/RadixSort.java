package ordenamiento.radix_sort;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Antes del ordenamiento:");
        printArray(arr);

        radixSort(arr);

        System.out.println("Después del ordenamiento:");
        printArray(arr);
    }

    // Función principal
    public static void radixSort(int[] arr) {
        // 1. Encontrar el número más grande para saber cuántos dígitos tiene
        int max = getMax(arr);

        // 2. Aplicar Counting Sort para cada dígito (unidad, decena, centena, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // Función auxiliar: obtiene el número más grande
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        return max;
    }

    // Counting Sort modificado para ordenar por el dígito "exp"
    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Arreglo de salida
        int[] count = new int[10]; // Para dígitos del 0 al 9

        // Contar ocurrencias de cada dígito
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Cambiar count[i] para que contenga posiciones reales
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir arreglo de salida de forma estable (de derecha a izquierda)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copiar al arreglo original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
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