public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Probando cositas");

        String s, s1;

        s1 = DecToBaseConverter.convert(73, 2);

        s = DecToBaseConverter.convertToHex(646543);

        s = BaseToDecConverter.convert("11",8);

        System.out.println(s1  + '\n' + s);

    }
}
// HOLA MUNDO

