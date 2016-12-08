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
      if (zip.length() != 5 || !numberString(zip)) {
	  throw new IllegalArgumentException("Barcodes may only contain 5 numerical digits");
      }
      else {
	  _zip = zip;
	  _checkDigit = checkSum();
      }
  }

  public static boolean numberString(String s) {
      for (int i = 0; i < s.length(); i++) {
	  if (s.charAt(i) < 48 || s.charAt(i) > 57) {
	      return false;
	  }
      }
      return true;
  }
 	      
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode barcode = new Barcode(_zip);
      return barcode;
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int ans = 0;
      for (int i = 0; i < _zip.length(); i++) {
	  ans += Character.getNumericValue(_zip.charAt(i));
      }
      return ans%10;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String ans = _zip + _checkDigit + "  |";
      String ansInitialCopy = ans;
      for (int i = 0; i < ansInitialCopy.length()-2; i++) {
	  ans += translate(Character.getNumericValue(ansInitialCopy.charAt(i)));
      }
      return ans + "|";
  }

  public String translate(int digit) {
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
	Barcode a = new Barcode("10282");
	System.out.println(a);
	Barcode b = a.clone();
	System.out.println(b);
	System.out.println(a.compareTo(b));
	Barcode c = new Barcode("01234");
	System.out.println(c);
	Barcode d = c.clone();
	System.out.println(d);
	System.out.println(c.compareTo(d));
	System.out.println(a.compareTo(c));
	System.out.println(c.compareTo(b));/*
	//Barcode e = new Barcode("143442");
	//Barcode f = new Barcode("14");
	//Barcode g = new Barcode("hello");
	*/
    }
}
