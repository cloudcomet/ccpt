public class Except {
// 	public static int max(int[] arr) {
// 		int i = 0, j = arr.length - 1;
// 		int m = Integer.MIN_VALUE;
// 		while (i <= j) {
// 			if (arr[i] > m) m = arr[i];
// 			if (arr[j] > m) m = arr[j];
// 			i++;
// 			j--;
// 		}
// 		return m;
// 	}

// 	public static void main(String[] args) {
// 		int[] a = {-10,-9, 8, 7, 6, 5, 4, 3, 2, 1};
		
// 		try {
// 			System.out.println("Maximum element of array: " + max(a));
// 		} catch (Exception e) {
// 			System.out.println("Error: " + e.getMessage());
// 		}
// }

//import java.util.Scanner;

// public class Main {

    public static int findMax(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int maxValue = Integer.MIN_VALUE;
		try{
        while (start <= end){

            // check is greater than max
            if (arr[start] > maxValue){
                maxValue = arr[start];
            }

            if (arr[end] > maxValue){
                maxValue = arr[end];
            }

            Thread t = new Thread();

            start++;
            end--;
        }
        return maxValue;
    }
}

    public static void main(String[] args)  {

       // Scanner sc =new Scanner(System.in);

        int[] arr = {};

        //System.out.println(findMax(arr));
		try{
			System.out.println(findMax(arr));	
        }
        catch (Exception e){
            System.out.println("Empty Array");
        }

    }
}

