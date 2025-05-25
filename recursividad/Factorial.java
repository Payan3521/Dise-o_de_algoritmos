public class Factorial {
    // Método iterativo
    public static int factorialIterativo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("No existe factorial de números negativos");
        }
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Método recursivo
    public static int factorialRecursivo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("No existe factorial de números negativos");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursivo(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial iterativo de " + n + ": " + factorialIterativo(n));
        System.out.println("Factorial recursivo de " + n + ": " + factorialRecursivo(n));
    }
} 