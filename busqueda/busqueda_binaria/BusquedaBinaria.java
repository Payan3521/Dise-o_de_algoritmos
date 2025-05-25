package busqueda.busqueda_binaria;

public class BusquedaBinaria {
     public static void main(String[] args) {
        int[] arr = {2, 4, 10, 23, 35, 40, 55, 70, 88};
        int target = 35;

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Elemento encontrado en el índice: " + index);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }

    // Búsqueda binaria iterativa
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1; // No encontrado
    }

    // Búsqueda binaria recursiva
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return binarySearchRecursive(arr, mid + 1, right, target);
        else
            return binarySearchRecursive(arr, left, mid - 1, target);
    }
}