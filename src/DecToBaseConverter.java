public class DecToBaseConverter 
{
  /**
   * Convierte un número decimal a otra base numérica (binario, octal o hexadecimal).
   * Utiliza el algoritmo de división repetida: divide el número entre la base repetidamente
   * y recoge los residuos en orden inverso.
   * 
   * @param dec el número decimal a convertir
   * @param base la base destino (2=binario, 8=octal, 10=decimal, 16=hexadecimal)
   * @return una cadena con el número convertido a la base especificada
   */
  public static String convertToBase(int dec, int base)
  {
    String str = "";
    int rema;
    while (dec >= base) 
    {
      rema = dec%base;
      str = Hex.getLetter(rema) + str;
      dec = dec/base;
    }

    str = dec + str;
    return str;
  }
}