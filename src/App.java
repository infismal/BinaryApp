import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        String result = null;

        System.out.println("Bienvenido al conversor de Bases - Aritmética y Complemento a 2");

        do{
            System.out.println();
            System.out.println("1. Convertir decimal a otras bases");
			System.out.println("2. Convertir de otras bases a decimal");
			System.out.println("3. Convertir entero a complemento a 2");
			System.out.println("4. Sumar y Restar en complemento a 2");
			System.out.println("0. Salir");
			System.out.printf("\nIngresa el número de opción y presiona ENTER: ");
			option = sc.nextInt();
			sc.nextLine();
            System.out.println();
			
			switch(option) {
			case 1:
				System.out.printf("Ingresa el decimal que deseas convertir: ");
				int decimal = sc.nextInt();
                
                System.out.println("\n ¿A qué base deseas convertir?");
                System.out.println("1. Binario");
                System.out.println("2. Octal");
                System.out.println("3. Decimal");
                System.out.println("4. Hexadecimal");
                System.out.printf("\nIngresa el número de tu opción: ");
				option = sc.nextInt();
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
                    System.out.printf("\nIngresa el número de tu opción: ");
                    option = sc.nextInt();
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
                System.out.printf("Ingresa el entero a convertir: ");
				int entero = sc.nextInt();

                    System.out.println("\nIngresa la cantidad de bits que deseas utilizar: ");
                    System.out.println("1. 4 Bits");
			        System.out.println("2. 8 Bits");
			        System.out.println("3. 16 Bits");
			        System.out.println("4. 32 Bits");
                    System.out.printf("\nIngresa el número de tu opción: ");
                    option = sc.nextInt();
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
                    System.out.printf("\nIngresa el número de tu opción: ");
                    int optBits = sc.nextInt();
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
                    System.out.printf("\nIngresa el número de tu opción: ");
                    option = sc.nextInt();
                    System.out.println();


                    switch(option){
                        case 1:
                            System.out.println("Ingresa el sumando1");
                            int sumand1 = sc.nextInt();
			                System.out.println("Ingresa el sumando2");
                            int sumand2 = sc.nextInt();

                            AddSubsBinary.normalize(sumand1, sumand2, numBits);
                            String total = AddSubsBinary.add(AddSubsBinary.add1, AddSubsBinary.add2);
                            System.out.println("La suma total es: " + total);
                            break;

                        case 2:
                            System.out.printf("Ingresa el minuendo: ");
                            int minuend = sc.nextInt();
			                System.out.printf("Ingresa el sustraendo: ");
                            int sustrahend = sc.nextInt();
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
}