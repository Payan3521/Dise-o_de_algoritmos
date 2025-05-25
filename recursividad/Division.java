public class Division {
    // Método iterativo
    public static int divisionIterativa(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("División por cero");
        }
        if (divisor == 1) {
            return dividendo;
        }
        
        int cociente = 0;
        int resto = Math.abs(dividendo);
        int divisorAbs = Math.abs(divisor);
        
        while (resto >= divisorAbs) {
            resto -= divisorAbs;
            cociente++;
        }
        
        return (dividendo < 0) ^ (divisor < 0) ? -cociente : cociente;
    }

    // Método recursivo
    public static int divisionRecursiva(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("División por cero");
        }
        if (divisor == 1) {
            return dividendo;
        }
        
        // Manejo de signos
        boolean esNegativo = (dividendo < 0) ^ (divisor < 0);
        int dividendoAbs = Math.abs(dividendo);
        int divisorAbs = Math.abs(divisor);
        
        int resultado = divisionRecursivaAux(dividendoAbs, divisorAbs);
        return esNegativo ? -resultado : resultado;
    }

    private static int divisionRecursivaAux(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        }
        return 1 + divisionRecursivaAux(dividendo - divisor, divisor);
    }

    public static void main(String[] args) {
        int dividendo = 20;
        int divisor = 4;
        
        System.out.println("División iterativa de " + dividendo + "/" + divisor + ": " + 
            divisionIterativa(dividendo, divisor));
        System.out.println("División recursiva de " + dividendo + "/" + divisor + ": " + 
            divisionRecursiva(dividendo, divisor));
    }
} 