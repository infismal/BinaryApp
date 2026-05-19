public class SignedBinaryConverter {

  private static final int base = 2;

  /**
   * Convierte un número decimal a su representación en complemento a 2 con una cantidad específica de bits.
   * Para números positivos, simplemente convierte a binario y rellena con ceros.
   * Para números negativos, aplica el complemento a 2 (invierte bits a partir del primer 1).
   * Si el número no cabe en los bits especificados, dobla automáticamente la cantidad de bits (máximo 32).
   * 
   * @param dec el número decimal a convertir (puede ser positivo o negativo)
   * @param bits la cantidad de bits deseados (4, 8, 16 o 32)
   * @return una cadena con la representación binaria en complemento a 2
   * @throws Exception si el número requiere más de 32 bits
   */
  public static String convertToSignedC2(int dec, int bits) throws Exception
  { 

    String bin = DecToBaseConverter.convertToBase(Math.abs(dec), base);
    int size = bin.length();  // actual bits of dec

    while( size >= bits)
    {
      if(bits > 32)  
        throw new Exception("Error: El número requiere más de 32 bits. No se puede representar.");

      System.out.println("El número no cabe en " + bits + " bits. Ajustando a " + (bits * 2) + " bits...\n");
      bits = bits * 2;   //8, 16, 32
    }

    int leftOverBits = bits - size;  // bits a rellenar
  
  
    for(int i = 0; i < leftOverBits; i++) // refill number with left overs
      bin = 0 + bin;
  
    
    if(dec >= 0)
      return bin;

    return negate(bin);
    
      
  }

  /**
   * Aplica el complemento a 2 a un número binario.
   * Algoritmo: encuentra el primer 1 desde la derecha, lo mantiene, y invierte todos los bits a su izquierda.
   * Esto es equivalente a invertir todos los bits y sumar 1.
   * 
   * @param bin el número binario al cual aplicar complemento a 2
   * @return una cadena con el complemento a 2 del número binario
   */
  private static String negate(String bin)
  {
    char[] c = bin.toCharArray(); int i;
    String str = "";
    
    for(i = c.length - 1; i >= 0; i--)
    {
      str = c[i] + str;
      if(Hex.getValueFromChar(c[i] + "") == 1)
        break;
    }
    for(int j = i - 1; j >= 0; j--)
    {
      c[j] = (c[j] == '0') ? '1' : '0';
      str = c[j] + str;
    }

    // System.out.println(str); : // debug
    return str; 
  }

  

}
