public class BaseToDecConverter {

    public static String convertToDec(String num, int base) {
        char[] c = num.toCharArray();
        int exp = 0;
        int resultado = 0;
        for(int i = c.length -1; i >= 0; i--) {
            String aux = "" + c[i];
            resultado += (int)(Hex.getValueFromChar(aux) * Math.pow(base, exp));
            exp++;
        }
        return "" + resultado;
    }

    // meant to show the conversion process

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