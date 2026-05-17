public class AddSubsBinary {

    public static String add1;
    public static String add2;

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

    public static String addition(String bin1, String bin2){

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
            System.out.println("Atención, se ha detectado overflow");
        }
        if(carryOut==1){
            System.out.println("Cuidado, la operación arrojó un acarreo");
        }

        return result;

        
    }

}
