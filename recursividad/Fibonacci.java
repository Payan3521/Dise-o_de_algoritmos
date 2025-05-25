public class Fibonacci {
    // Método iterativo
    public static int fibonacciIterativo(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Método recursivo
    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci iterativo de " + n + ": " + fibonacciIterativo(n));
        System.out.println("Fibonacci recursivo de " + n + ": " + fibonacciRecursivo(n));
    }
} 