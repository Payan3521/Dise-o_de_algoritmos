public class SumaArray {
    // Método iterativo
    public static int sumaArrayIterativo(int[] arr) {
        int suma = 0;
        for (int num : arr) {
            suma += num;
        }
        return suma;
    }

    // Método recursivo
    public static int sumaArrayRecursivo(int[] arr) {
        return sumaArrayRecursivoAux(arr, 0);
    }

    private static int sumaArrayRecursivoAux(int[] arr, int indice) {
        if (indice == arr.length) {
            return 0;
        }
        return arr[indice] + sumaArrayRecursivoAux(arr, indice + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Suma iterativa del array: " + sumaArrayIterativo(arr));
        System.out.println("Suma recursiva del array: " + sumaArrayRecursivo(arr));
    }
} 