package busqueda.busqueda_lineal;

public class BusquedaLineal {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 7, 5, 8};
        int target = 7;

        int index = linearSearch(arr, target);

        if (index != -1) {
            System.out.println("Elemento encontrado en el índice: " + index);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }

    // Método de búsqueda lineal
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1; // No encontrado
    }
}
