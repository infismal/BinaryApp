

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

  private String getDisplayName() {
    if (this.name().startsWith("_")) {
        return this.name().substring(1); // Remove the leading underscore
    }
    return this.name(); // Return the name as is for A-F
  }

  // Método para obtener el nombre (A, B, C...) según el número
  public static String getLetter(int number) {
      for (Hex hd : Hex.values()) {
          if (hd.getValue() == number) {
              return hd.getDisplayName();
          }
      }
      return String.valueOf(number); // Retorna el número si es 0-9
  }

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

//tes