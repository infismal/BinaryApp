public class DecToBaseConverter 
{
  public static String convert(long dec, int base)
  {
    String str = "";
    long rema;
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

/// test