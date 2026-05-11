public class BaseToDecConverter {

    public static String convert(String num, int base) {
        char[] c = num.toCharArray();
        int exp = 0;
        long resultado = 0;
        for(int i = c.length -1; i >= 0; i--) {
            String aux = "" + c[i];
            resultado += Hex.getValueFromChar(aux) * (long)Math.pow(base, exp);
            exp++;
        }
        return "" + resultado;
    }
}
