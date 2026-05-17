import java.util.Scanner;

public class BinaryApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        String result = null;

        System.out.println("Bienvenido a BinaryApp");
        
        do{
            System.out.println();
            System.out.println("1. Convertir decimal a otras bases");
			System.out.println("2. Convertir de otras bases a decimal");
			System.out.println("3. Convertir entero a complemento a 2");
			System.out.println("4. Sumar y Restar en complemento a 2");
			System.out.println("0. Salir");
            option = readInt(sc, "\nIngresa el número de opción y presiona ENTER: ");
            System.out.println();
			
			switch(option) {
			case 1:
                int decimal = readInt(sc, "Ingresa el decimal que deseas convertir: ");
                
                System.out.println("\n ¿A qué base deseas convertir?");
                System.out.println("1. Binario");
                System.out.println("2. Octal");
                System.out.println("3. Decimal");
                System.out.println("4. Hexadecimal");
                option = readInt(sc, "\nIngresa el número de tu opción: ");
                System.out.println();

                switch(option){
                        case 1:
                            result = DecToBaseConverter.convertToBase(decimal, 2);
                            System.out.println("Número convertido: " + result);
                            break;
                        case 2:
                            result = DecToBaseConverter.convertToBase(decimal, 8);
                            System.out.println("Número convertido: " + result);
                            break;
                        case 3:
                            result = DecToBaseConverter.convertToBase(decimal, 10);
                            System.out.println("Número convertido: " + result);
                            break;
                        case 4:
                            result = DecToBaseConverter.convertToBase(decimal, 16);
                            System.out.println("Número convertido: " + result);
                            break;
                        default:
                            System.out.println("Tu opción no es válida");
                            break;

    
                }
                break;
				
			case 2:
                    System.out.printf("\nIngresa el número que deseas convertir: ");
                    String num = sc.next();
                    System.out.println("\n ¿A qué sistema numérico pertenece el número que ingresaste?");
			        System.out.println("1. Binario");
			        System.out.println("2. Octal");
                    System.out.println("3. Decimal");
			        System.out.println("4. Hexadecimal");
                    option = readInt(sc, "\nIngresa el número de tu opción: ");
                    System.out.println();

                    switch(option){
                        case 1:
                            result = BaseToDecConverter.convertToDec(num, 2);
                            System.out.println("Número convertido: " + result);
                            break;
                        case 2:
                            result = BaseToDecConverter.convertToDec(num, 8);
                            System.out.println("Número convertido: " + result);
                            break;
                        case 3:
                            result = BaseToDecConverter.convertToDec(num, 10);
                            System.out.println("Número convertido: " + result);
                            break;
                        case 4:
                            result = BaseToDecConverter.convertToDec(num, 16);
                            System.out.println("Número convertido: " + result);
                            break;
                        default:
                            System.out.println("Tu opción no es válida");
                            break;
                    }

                break;

            case 3:
                int entero = readInt(sc, "Ingresa el entero a convertir: ");

                    System.out.println("\nIngresa la cantidad de bits que deseas utilizar: ");
                    System.out.println("1. 4 Bits");
			        System.out.println("2. 8 Bits");
			        System.out.println("3. 16 Bits");
			        System.out.println("4. 32 Bits");
                    option = readInt(sc, "\nIngresa el número de tu opción: ");
                    System.out.println();

                    switch(option){
                        case 1:
                            result = SignedBinaryConverter.convertToSignedC2(entero, 4);
                            System.out.println("Número en complemento a 2: " + result);
                            break;

                        case 2:
                            result = SignedBinaryConverter.convertToSignedC2(entero, 8);
                            System.out.println("Número en complemento a 2: " + result);
                            break;
                        case 3:
                            result = SignedBinaryConverter.convertToSignedC2(entero, 16);
                            System.out.println("Número en complemento a 2: " + result);
                            break;
                        case 4:
                            result = SignedBinaryConverter.convertToSignedC2(entero, 32);
                            System.out.println("Número en complemento a 2: " + result);
                            break;
                        default:
                            System.out.println("Tu opción no es válida");
                            break;
                    }

                System.out.println("\n=== VERIFICACION (Revirtiendo C2 a Decimal) ===");
                BaseToDecConverter.revertToBaseInstructive(result);
                break; 
			
			case 4:
                    System.out.println("\n¿Con qué cantidad de bits quieres expresar tu respuesta? ");
                    System.out.println("\nNota: La cantidad de bits que elijas determinará si existe o no overflow ");
                    System.out.println("1. 4 Bits");
			        System.out.println("2. 8 Bits");
			        System.out.println("3. 16 Bits");
			        System.out.println("4. 32 Bits");
                    int optBits = readInt(sc, "\nIngresa el número de tu opción: ");
                    int numBits = 0;
                    switch (optBits) {
                        case 1:
                            numBits = 4;
                            break;
                        case 2:
                            numBits = 8;
                            break;
                        case 3:
                            numBits = 16;
                            break;
                        case 4:
                            numBits = 32;
                            break;
                    
                        default:
                            break;
                    }

                    System.out.println("\n ¿Qué operación deseas realizar? ");
			        System.out.println("1. Sumar en complemento a 2");
			        System.out.println("2. Restar en complemento a 2");
                    option = readInt(sc, "\nIngresa el número de tu opción: ");
                    System.out.println();


                    switch(option){
                        case 1:
                            int sumand1 = readInt(sc, "Ingresa el sumando1: ");
                            int sumand2 = readInt(sc, "Ingresa el sumando2: ");

                            AddSubsBinary.normalize(sumand1, sumand2, numBits);
                            String total = AddSubsBinary.add(AddSubsBinary.add1, AddSubsBinary.add2);
                            System.out.println("La suma total es: " + total);
                            break;

                        case 2:
                            int minuend = readInt(sc, "Ingresa el minuendo: ");
                            int sustrahend = readInt(sc, "Ingresa el sustraendo: ");
                            String diference = AddSubsBinary.substract(minuend, sustrahend, numBits);
                            System.out.println("La diferencia es: " + diference);
                            break;
                        default:
                            System.out.println("Tu opción no es válida");
                            break;
                    }
				
				break;
				
			case 0:
				System.out.println("Saliendo del programa, un gusto verlo...");
				
            }

		}while(option != 0);
		
		sc.close();
      
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número entero.");
            }
        }
    }
}