public class BaseToDecConverter {

    public static String convert(String num, int base) {
        char[] c = num.toCharArray();
        int exp = 0;
        int resultado = 0;
        for(int i = c.length -1; i >= 0; i--) {
            String aux = "" + c[i];
            resultado += Hex.getValueFromChar(aux) * (int)Math.pow(base, exp);
            exp++;
        }
        return "" + resultado;
    }

    // meant to show the conversion process

    public static String revertToBaseInstructive(String num) { 

        char[] c = num.toCharArray();
        int exp = 0, resultado = 0, base = 2, i;

        for(i = c.length -1; i >= 0; i--) {
            String aux = "" + c[i];

            if( i == 0  && c[i] == '1')
            {
                resultado += (int)(-Hex.getValueFromChar(aux) * Math.pow(base, exp));
                break;
            }

            resultado += (int)(Hex.getValueFromChar(aux) * (int)Math.pow(base, exp));  //(base, exp);
            exp++;
        }

        // resultado -=  Hex.getValueFromChar(c[0] + "") * (int)Math.pow(base, exp);

        return "" + resultado;
    }
}

// resultado += Hex.getValueFromChar(aux) * (int)Math.pow(base, exp);