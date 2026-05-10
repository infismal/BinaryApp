

public enum Hex 
{
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

  // Método para obtener el nombre (A, B, C...) según el número
  public static String getLetter(int number) {
      for (Hex hd : Hex.values()) {
          if (hd.getValue() == number) {
              return hd.name();
          }
      }
      return String.valueOf(number); // Retorna el número si es 0-9
  }
  
}

//tes