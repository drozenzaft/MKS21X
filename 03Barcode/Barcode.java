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
      boolean a = isCode(zip);
      if (a) {
	  _zip = zip;
	  _checkDigit = checkSum(this);
      }
  }

  private static boolean isCode(String s) {
      int i = 0;
      while (i <= s.length()) {
	  if (s.charAt(i) < 48 || s.charAt(i) > 57 || i > 5 || i < 5 && i == s.length()) {
	      throw new IllegalArgumentException("Barcodes may only contain 5 numerical digits");
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
  private static int checkSum(Barcode barcode){
      int ans = 0;
      for (int i = 0; i < barcode._zip.length(); i++) {
	  ans += Character.getNumericValue(barcode._zip.charAt(i));
      }
      return ans%10;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String combo = _zip + _checkDigit;
      for (int i = 0; i < _zip.length
      String ans = combo + "  |" + toBarcode(this) + "|";
      return ans;
  }
    
    private static String toZip(String code) {
	String ans = "";
	boolean a = isCode(code);	
	for (int i = 1; i < code.length(); i+5) {
	    while (!toBarcode(j).equals(code.substring(i,i+5)) && j < 10) {
		j++;
	    }
	    if (j < 10) {
		ans += j;
	    }
	    else {
		throw new IllegalArgumentException("Invalid code. Please insert a proper code.");
	}
	return ans;
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


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return (_zip+_checkDigit).compareTo(other._zip+other._checkDigit);
  }
    public static void main(String[] args) {
	/*Barcode a = new Barcode("10282");
	System.out.println(a);
	Barcode c = new Barcode("01234");
	System.out.println(c);
	System.out.println(a.compareTo(c));
	//Barcode e = new Barcode("143442");
	//Barcode f = new Barcode("14");
	//Barcode g = new Barcode("hello");*/
	}
}
