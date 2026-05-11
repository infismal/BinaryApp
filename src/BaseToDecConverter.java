public class BaseToDecConverter {

    public static String convert(String num, int base) {
        char[] c = num.toCharArray();
        int exp = 0;
        int resultado = 0;
        for(int i = c.length -1; i >= 0; i--) {
            resultado += Character.getNumericValue(c[i]) * Math.powExact(base, exp);
            exp++;
        }
        return "" + resultado;
    }
}
