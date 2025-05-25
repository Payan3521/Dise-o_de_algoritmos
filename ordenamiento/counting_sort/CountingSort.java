package ordenamiento.counting_sort;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Antes del ordenamiento:");
        printArray(arr);

        countingSort(arr);

        System.out.println("Después del ordenamiento:");
        printArray(arr);
    }

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // 1. Encontrar el valor máximo
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // 2. Crear arreglo de conteo
        int[] count = new int[max + 1];

        // 3. Contar ocurrencias
        for (int num : arr) {
            count[num]++;
        }

        // 4. Reconstruir arreglo ordenado
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
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
