package Chapter5;
/**
 * 
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation.
 * If the number can not be represented accurately in binary, print “ERROR”
 *
 */
public class Q5_2 {
	public static String convertToBinary(String in) {
		int before_decimal = Integer.parseInt(in.substring(0, in.indexOf('.')));
		double decimal_part = Double.parseDouble(in.substring(in.indexOf('.'), in.length()));
		StringBuilder sb1 = new StringBuilder("");
		while(before_decimal > 0) {
			sb1.append(before_decimal%2);
			before_decimal /= 2;
		}
		StringBuilder sb2 = new StringBuilder("");
		while(decimal_part > 0) {
			if(sb2.length() > 32) {
				//Raise Error
				return "ERROR";
			}
			double r = decimal_part*2;
			if(r >= 1) {
				sb2.append(1);
				decimal_part = r-1;
			}else {
				sb2.append(0);
				decimal_part = r;
			}
		}
		return sb1.reverse().append(".").append(sb2).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convertToBinary("3.25"));
	}
}
