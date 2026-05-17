public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Probando cositas");

        String s, s1, s2, s3;

        s1 = DecToBaseConverter.convert(73, 2);

        System.out.printf("%s ", s1);


        System.out.println(SignedBinaryConverter.convertToSignedC2(-356, 4));
        System.out.println(DecToBaseConverter.convert(645623, 16));

        s3 = SignedBinaryConverter.convertToSignedC2(-65535, 4);

        System.out.println(s3);
        System.out.println(BaseToDecConverter.revertToBaseInstructive(s3));


        AddSubsBinary.normalize(-7, -7, 4);

        System.out.println("Sumando: \n" + AddSubsBinary.add1 + " y \n" + AddSubsBinary.add2);

        System.out.println(AddSubsBinary.addition(AddSubsBinary.add1, AddSubsBinary.add2));
      

    }
}

//  2^bits -1 = max
// c2: (2^bits-1) - 1  | 2^bits-1