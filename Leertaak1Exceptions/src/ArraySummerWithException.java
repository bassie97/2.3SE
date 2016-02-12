import java.util.Arrays;
import java.util.Scanner;
public class ArraySummerWithException { 
	
	public static void main(String[] args){
		try {
			int[] arr1 = {1, 2, 3};
			int[] arr2 = {3, 2};
			int[] arr3 = {5, 5, 8};
			
			summer(arr1, arr3);
			summer(arr1, arr2);
			
		}
		catch(ArraySizeException ex){
			ex.printStackTrace();		
		}
	}

	private static void summer(int[] arr1, int[] arr2) throws ArraySizeException{
		int[] resultArr = new int[arr1.length];
		int length1 = arr1.length;
		int length2 = arr2.length;
		if(length1 != length2){
			throw new ArraySizeException(length1, length2);
		}
		else
		{
			for(int i = 0; i < length1; i++){  
				resultArr[i] = arr1[i] + arr2[i];
			}
			System.out.println(Arrays.toString(resultArr));
		}	
	}

}
