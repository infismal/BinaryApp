public class DecToBaseConverter 
{
  public static String convert(int dec, int base)
  {
    String str = "";
    while (dec >= base) 
    {
      str = dec%base + str;
      dec = dec/base;
    }

    str = dec + str;
    return str;
  }
  
  public  static  String convertToHex(int dec)
  {
    String str = "";
    int rema;
    while (dec >= 16) 
    {
      rema = dec%16;
      if(rema >= 10)
      {
        str = Hex.getLetter(rema) + str;
      }else{str = rema + str;}

      dec = dec/16;
    }
    str = dec + str;
    return str;
  }

}

/// test