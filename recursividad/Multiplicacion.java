public class Multiplicacion {
    // Método iterativo
    public static int multiplicacionIterativa(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        
        boolean esNegativo = (a < 0) ^ (b < 0);
        int aAbs = Math.abs(a);
        int bAbs = Math.abs(b);
        
        int resultado = 0;
        for (int i = 0; i < bAbs; i++) {
            resultado += aAbs;
        }
        
        return esNegativo ? -resultado : resultado;
    }

    // Método recursivo
    public static int multiplicacionRecursiva(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        
        boolean esNegativo = (a < 0) ^ (b < 0);
        int aAbs = Math.abs(a);
        int bAbs = Math.abs(b);
        
        int resultado = multiplicacionRecursivaAux(aAbs, bAbs);
        return esNegativo ? -resultado : resultado;
    }

    private static int multiplicacionRecursivaAux(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a + multiplicacionRecursivaAux(a, b - 1);
    }


    public static void main(String[] args) {
        int a = 5;
        int b = 4;
        
        System.out.println("Multiplicación iterativa de " + a + " * " + b + ": " + 
            multiplicacionIterativa(a, b));
        System.out.println("Multiplicación recursiva de " + a + " * " + b + ": " + 
            multiplicacionRecursiva(a, b));
    }
} 