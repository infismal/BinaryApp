public class AddSubsBinary {

    public static String add1;
    public static String add2;
    public static boolean substraction = false;

    /**
     * Normaliza dos números decimales convirtiéndolos a complemento a 2 con la misma cantidad de bits.
     * Asegura que ambos operandos tengan la misma longitud binaria antes de realizar operaciones.
     * Los números normalizados se guardan en las variables de clase add1 y add2.
     * 
     * @param dec1 el primer número decimal
     * @param dec2 el segundo número decimal
     * @param bits la cantidad de bits para la representación
     * @throws Exception si los números no caben en 32 bits
     */
    public static void normalize(int dec1, int dec2, int bits) throws Exception{

        String bin1 = SignedBinaryConverter.convertToSignedC2(dec1, bits);
	    String bin2 = SignedBinaryConverter.convertToSignedC2(dec2, bits);

        if(bin1.length() > bin2.length()){
        
            bin2 = SignedBinaryConverter.convertToSignedC2(dec2, bin1.length());

	    }else if(bin2.length() > bin1.length()){

	    	bin1 = SignedBinaryConverter.convertToSignedC2(dec1, bin2.length());
	    }

        add1 = bin1;
        add2 = bin2;

    }

    /**
     * Realiza la resta de dos números en complemento a 2.
     * Implementa la operación: A - B = A + (-B)
     * Convierte el sustraendo a negativo y luego lo suma al minuendo.
     * 
     * @param dec1 el minuendo (número del cual restar)
     * @param dec2 el sustraendo (número a restar)
     * @param bits la cantidad de bits para la representación
     * @return una cadena con el resultado binario de la resta en complemento a 2
     * @throws Exception si los números no caben en 32 bits o hay overflow
     */
    public static String substract(int dec1, int dec2, int bits) throws Exception{
        normalize(dec1, -dec2, bits);
        return add(add1, add2);

    }

    /**
     * Suma dos números binarios en complemento a 2, detectando posible overflow.
     * Realiza la suma bit a bit desde la derecha hacia la izquierda, propagando los acarreos.
     * Detecta overflow comparando si el acarreo que entra al bit de signo es diferente al que sale.
     * Muestra alertas si hay overflow o acarreo final.
     * 
     * @param bin1 el primer número binario como cadena
     * @param bin2 el segundo número binario como cadena
     * @return una cadena con el resultado binario de la suma
     */
    public static String add(String bin1, String bin2){

        char[] add1 = bin1.toCharArray(), add2 = bin2.toCharArray();
 
        int carryIn = 0;
        int carryOut = 0;

        int carryInSignBit = 0;
        int carryOutSignBit = 0;

        boolean overflow = false;

        int base = 2;

        String result = "";

        for(int i = add1.length-1; i>=0; i--){

            if (i == 1) {
                carryInSignBit = (carryIn + Hex.getValueFromChar(add1[i] + "") + Hex.getValueFromChar(add2[i] + "")) / base;
            }
            
            result = (carryIn + Hex.getValueFromChar(add1[i] + "") + Hex.getValueFromChar(add2[i] + ""))%base + result;
            
            carryIn = (carryIn + Hex.getValueFromChar(add1[i] + "") + Hex.getValueFromChar(add2[i] + ""))/base;
            
            
        }

        carryOutSignBit = carryIn;

        carryOut = carryIn%base;

        if (carryInSignBit != carryOutSignBit) {
            overflow = true;
        }

        if(overflow){
            System.out.println("Atención, se ha detectado overflow\n");
        }
        if(carryOut==1){
            System.out.println("Cuidado, la operación arrojó un acarreo\n");
        }

        return result;

        
    }

}
