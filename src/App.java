public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Probando cositas");

        // String s, s1, s2;

        // s1 = DecToBaseConverter.convert(73, 2);

        // System.out.printf("%s ", s1);


        System.out.println(SignedBinaryConverter.convertToSignedC2(-65535, 16));
        System.out.println(SignedBinaryConverter.convertToSignedC2(-0, 2));
        System.out.println(BaseToDecConverter.revertToBaseInstructive("11111111111111110000000000000001"));
        System.out.println(SignedBinaryConverter.convertToSignedC2(-0, 16));
        System.out.println(DecToBaseConverter.convert(-0, 8));
        // System.out.println(BaseToDecConverter.revertToBaseInstructive("11111111111111110000000000000001"));

        System.out.println(BaseToDecConverter.revertToBaseInstructive("1000"));
      

       
        System.out.println(BaseToDecConverter.revertToBaseInstructive("11111111111111110000000000000001"));
      

    }
}

//  2^bits -1 = max
// c2: (2^bits-1) - 1  | 2^bits-1