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
      if (zip.length() != 5) {
	  throw new RuntimeException("Barcodes may only contain 5 numerical digits");
      }
      if (numberString(zip)) {
	  _zip = zip;
	  _checkDigit = checkSum();
      }
      else {
	  throw new RuntimeException("Barcodes may only contain numerical digits");
      }
  }

  public boolean numberString(String s) {
      for (int i = 0; i < s.length(); i++) {
	  if (i < 48 || i > 57) {
	      return false;
	  }
      }
      return true;
  }
 	      
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode barcode = new Barcode(_zip,_checkDigit);
      return barcode;
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int ans = 0;
      for (int i = 0; i < _zip.length(); i++) {
	  ans += Integer.parseInt(_zip.charAt(i));
      }
      return ans%10;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String ans = _zip + _checkDigit + "  ";
      String checkDigitString = " " + _checkDigit;
      for (int i = 0; i < ans.length(); i++) {
	  ans += translate(Integer.parseInt(checkDigitString.charAt(i)));
      }
      return ans;
  }

  public String translate(int digit) {
      String translation;
      if (digit == 0) {
	  digit = 10;
      }
      switch (digit) {
      case 1:  translation = ":::||";
	  break;
      case 2:  translation = "::|:|";
	  break;
      case 3:  translation = "::||:";
	  break;
      case 4:  translation = ":|::|";
	  break;
      case 5:  translation = ":|:|:";
	  break;
      case 6:  translation = ":||::";
	  break;
      case 7:  translation = "|:::|";
	  break;
      case 8:  translation = "|::|:";
	  break;
      case 9:  translation = "|:|::";
	  break;
      case 10: translation = "||:::";
	  break;
      }
      return translation;
  }


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return checkDigit - other.checkDigit;
  }
}
