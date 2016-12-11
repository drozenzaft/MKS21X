public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      boolean a = isBarcode(zip);
      if (a) {
	  _zip = zip;
	  _checkDigit = checkSum(zip);
      }
  }

  private static boolean isBarcode(String s) {
      int i = 0;
      while (i < s.length()) {
	  if (s.charAt(i) < 48 || s.charAt(i) > 57 || i != 4 && i == s.length()-1) {
	      throw new IllegalArgumentException("Barcodes may only contain 5 numerical digits");
	  }
	  i++;
      }
      return true;
  }
   private static boolean isCode(String s) {
      int i = 0;
      if (s.charAt(0) != '|' || s.charAt(s.length()-1) != '|' || s.length() != 32) {
	  throw new IllegalArgumentException("Invalid code: Codes must be 32 characters long and start and end with a vertical bar");
      }
      while (i < s.length()) {
	  if (s.charAt(i) != ':' && s.charAt(i) != '|') {
		  throw new IllegalArgumentException("Invalid code: Codes may only contain colons and vertical bars");
	  }
	  i++;
      }
      return true;
  }
 	      
// postcondition: Creates a copy of a bar code.
//  public Barcode clone(){
    //    Barcode barcode = new Barcode(_zip);
    //return barcode;
    //}


// postcondition: computes and returns the check sum for _zip
  private static int checkSum(String zip){
      int ans = 0;
      for (int i = 0; i < zip.length(); i++) {
	  ans += Character.getNumericValue(zip.charAt(i));
      }
      return ans%10;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      return  _zip + _checkDigit + " " + toCode(_zip);
  }
    
    public static String toZip(String code) {
	String ans = "";
	boolean a = isCode(code);
	int j;
	for (int i = 1; i < code.length()-1; i+=5) {
	    j = 0;
	    while (!toBarcode(j).equals(code.substring(i,i+5)) && j < 10) {
		j++;
	    }
	    if (j < 10) {
		ans += j;
	    }
	    else {
		throw new IllegalArgumentException("Invalid code. Please insert a proper code, with proper encoded integers, a proper checksum ,only colons and vertical bars, and a length of 32.");
	    }
	}
	return ans.substring(0,5);
    }
	
    private static String toBarcode(int digit) {
      String translation = "";
      switch (digit) {
      case 0:  translation += "||:::";
	  break;
      case 1:  translation += ":::||";
	  break;
      case 2:  translation += "::|:|";
	  break;
      case 3:  translation += "::||:";
	  break;
      case 4:  translation += ":|::|";
	  break;
      case 5:  translation += ":|:|:";
	  break;
      case 6:  translation += ":||::";
	  break;
      case 7:  translation += "|:::|";
	  break;
      case 8:  translation += "|::|:";
	  break;
      case 9:  translation += "|:|::";
	  break;
      }
      return translation;
  }
    public static String toCode(String zip) {
	boolean a = isBarcode(zip.substring(0,zip.length()));
	zip += checkSum(zip);
	String ans = "";
	for (int i = 0; i < zip.length(); i++) {
	    ans += toBarcode(Character.getNumericValue(zip.charAt(i)));
	}
	return "|"+ans+"|";
    }
	    
// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return (_zip+_checkDigit).compareTo(other._zip+other._checkDigit);
  }
    public static void main(String[] args) {
	//Barcode a = new Barcode("10282");
	
	//System.out.println(a.toZip("|:::||||:::::|:||::|:::|:|::||:|"));
	//System.out.println("  " + a.toCode(a._zip+a._checkDigit));
	//System.out.println(a);
	//Barcode c = new Barcode("01234");
	//System.out.print(c.toZip(c.toCode(c._zip+c._checkDigit)));
	//System.out.println("  " + c.toCode(c._zip+c._checkDigit));
	//System.out.println(c);
	//System.out.println(a.compareTo(c));
	//System.out.println(c.compareTo(a));
	//System.out.println(a.compareTo(a));
	//System.out.println(c.compareTo(c));
	//Barcode e = new Barcode("143442");
	//Barcode f = new Barcode("14");
	//Barcode g = new Barcode("hello");
	}
}
