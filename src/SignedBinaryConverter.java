public class SignedBinaryConverter {

  private static final int base = 2;

  public static String convertToSignedC2(int dec, int bits) throws Exception
  { 

    String bin = DecToBaseConverter.convert(Math.abs(dec), base);
    int size = bin.length();  // actual bits of dec

    while( size >= bits)
    {
      System.out.println("Ajustando tamaño de bits ...");

      if(bits > 32) 
        throw new Exception("mensaje de error genérico");

      bits = bits * 2;   //4 , 8, 16, 32
    }

    int leftOverBits = bits - size;  // bits a rellenar
  
  
    for(int i = 0; i < leftOverBits; i++) // refill number with left overs
      bin = 0 + bin;
  
    
    if(dec >= 0)
      return bin;

    return negate(bin);
    
      
  }

  private static String negate(String bin)       // 00001001010
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
