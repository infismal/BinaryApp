public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Probando cositas");

        String s, s1, s2;

        s1 = DecToBaseConverter.convert(73, 2);

        s2 = DecToBaseConverter.convert(646543, 16);

        s = BaseToDecConverter.convert("3456544FEAD",16);

        System.out.println(s  + '\n' + s1 + "\n" + s2);

    }
}
// HOLA MUNDO

