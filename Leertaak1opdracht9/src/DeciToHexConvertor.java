
public class DeciToHexConvertor {
	 // the decimal number that must be converted to Hex don't forget the L if using long
	 static long dec = 3405691582L;
	 static String hex;
	 
	 //main method that will be used when java is run
	 public static void main(String [ ] args)
	 {
	  //converts dec to hex and punts the answer in the string hex
	  hex = Long.toString(dec,16);
	  // print the hex number to the console
	  System.out.println(hex);
	 }
}
