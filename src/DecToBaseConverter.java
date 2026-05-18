public class DecToBaseConverter 
{
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