
public class ArraySizeException extends Exception {
	public ArraySizeException(int length1, int length2){
		super("Arrays not same size Array1: " + length1 + " and Array2: " + length2);		
	}
}
