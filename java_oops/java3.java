import java.util.*;

class java3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the element to be found of array : ");
        // int n = sc.nextInt();
        int[] arr = {1,2,3,4,5};
        // System.out.print("Enter the elements of array : ");
        // for(int i=0; i<arr.length; i++){
        //     arr[i] = sc.nextInt();
        // }
        // System.out.print("The elements of array are : ");
        int s=arr[0], i=0;
        int[] arr2 = new int[arr.length];
        for(i=arr.length-1; i>=0; i--){
            // if(arr[i]==n){
            //     s=arr[i];
            //     break;
            // }
            
            // System.out.print(arr[i]);
        }
        System.out.print("\nThe reverse of array elements are : "+arr2);
        sc.close();

    }
}