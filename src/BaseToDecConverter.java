public class BaseToDecConverter {

    /**
     * Convierte un número de cualquier base al sistema decimal.
     * Utiliza la notación posicional: multiplica cada dígito por la base elevada
     * al exponente de su posición y suma todos los resultados.
     * 
     * @param num el número a convertir (como cadena de texto)
     * @param base la base del número original (2=binario, 8=octal, 16=hexadecimal)
     * @return una cadena con el número convertido a decimal, o un mensaje de error si hay dígito inválido
     */
    public static String convertToDec(String num, int base) {
        char[] c = num.toCharArray();
        int exp = 0;
        int resultado = 0;
        for(int i = c.length -1; i >= 0; i--) {
            String aux = "" + c[i];
            int val = Hex.getValueFromChar(aux);
            if (val < 0 || val >= base) {
                return "Error: dígito '" + aux + "' no válido para base " + base;
            }
            resultado += (int)(val * Math.pow(base, exp));
            exp++;
        }
        return "" + resultado;
    }

    /**
     * Convierte un número binario en complemento a 2 a decimal, mostrando el proceso paso a paso.
     * Útil con fines educativos para entender cómo se realiza la conversión.
     * Trata el primer bit como el bit de signo (negativo).
     * 
     * @param num el número binario a convertir (como cadena de texto)
     * @return una cadena con el número decimal resultante
     */
    public static String revertToBaseInstructive(String num) { 

        char[] c = num.toCharArray();
        int exp = 0, resultado = 0, base = 2, i;
        
        System.out.println("\nBinario: " + num);
        
        for(i = c.length -1; i > 0; i--) {
            String aux = "" + c[i];
            int bitValue = (int)(Hex.getValueFromChar(aux) * Math.pow(base, exp));
            resultado += bitValue;
            System.out.println("Bit " + exp + ": " + aux + " * 2^" + exp + " = " + bitValue);
            exp++;
        }
        
        int signValue = (int)Math.pow(base, exp);
        System.out.println("Bit signo: " + c[0] + " * -2^" + exp + " = -" + signValue);
        resultado -=  Hex.getValueFromChar(c[0] + "") * Math.pow(base, exp);

        System.out.println("Resultado: " + resultado + "\n");
        return "" + resultado;
    }
}