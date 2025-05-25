public class Potencia {
    // Método iterativo
    public static double potenciaIterativa(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        double resultado = 1;
        for (int i = 0; i < Math.abs(exponente); i++) {
            resultado *= base;
        }
        return exponente < 0 ? 1/resultado : resultado;
    }

    // Método recursivo
    public static double potenciaRecursiva(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        if (exponente < 0) {
            return 1 / potenciaRecursiva(base, -exponente);
        }
        return base * potenciaRecursiva(base, exponente - 1);
    }

    public static void main(String[] args) {
        double base = 2;
        int exponente = 10;
        System.out.println("Potencia iterativa de " + base + "^" + exponente + ": " + 
            potenciaIterativa(base, exponente));
        System.out.println("Potencia recursiva de " + base + "^" + exponente + ": " + 
            potenciaRecursiva(base, exponente));
    }
} 