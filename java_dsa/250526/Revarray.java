import java.util.Scanner;
// public class Revarray {
//     public static void revarray(int[] arr, int index) {
//     // public static void printArray(int [] arr, int index){
//         // base case
//         if (arr.length == index)
//             return;

//         revarray(arr, index+1);
//         System.out.println(arr[index]);
// //        int newIndex = index+1;
//     }

//     public static void main(String[] args) {

//         Scanner input = new Scanner(System.in);

//         revarray(new int[]{1, 2, 3, 4, 5}, 0);

//     }
// }
public class Revarray {
    public static int sum(int[] arr, int index) {
        if (arr.length == index)
            return 0;
        return arr[index] + sum(arr, index+1);
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(sum(new int[]{1, 2, 3, 4, 5}, 0));

    }
}