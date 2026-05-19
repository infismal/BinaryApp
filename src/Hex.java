

public enum Hex 
{
  _0(0),
  _1(1),
  _2(2),
  _3(3),
  _4(4),
  _5(5),
  _6(6),
  _7(7),  
  _8(8),
  _9(9),

  A(10),
  B(11),
  C(12),
  D(13),
  E(14),
  F(15);

  private final int value;

  Hex(int value) 
  {
      this.value = value;
  }

  public int getValue(){return value;}

  /**
   * Obtiene el nombre de visualización de este valor hexadecimal.
   * Elimina el guion bajo de los números (ej: _0 → 0)
   * Retorna las letras tal como están (A, B, C, etc.)
   * 
   * @return una cadena con el nombre de visualización (0-9 o A-F)
   */
  private String getDisplayName() {
    if (this.name().startsWith("_")) {
        return this.name().substring(1); // Remove the leading underscore
    }
    return this.name(); // Return the name as is for A-F
  }

  /**
   * Convierte un valor numérico (0-15) a su representación hexadecimal (0-9 o A-F).
   * 
   * @param number el valor numérico a convertir (0-15)
   * @return una cadena con la representación hexadecimal (0-9 o A-F)
   */
  public static String getLetter(int number) {
      for (Hex hd : Hex.values()) {
          if (hd.getValue() == number) {
              return hd.getDisplayName();
          }
      }
      return String.valueOf(number); // Retorna el número si es 0-9
  }

  /**
   * Convierte un carácter hexadecimal (0-9 o A-F) a su valor numérico (0-15).
   * 
   * @param c el carácter hexadecimal como cadena (0-9 o A-F)
   * @return el valor numérico (0-15), o -1 si no es un carácter válido
   */
  public static int getValueFromChar(String c)
  {
    for (Hex hd : Hex.values()) {
        if (hd.getDisplayName().equals(c)) {
            return  hd.getValue();
        }
    }
    return -1;
  }
  
}