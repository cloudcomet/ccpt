// Linear search algorithm implementation in Java

public class Linear {
    public static int findfirstoccurance(int[] arr, int target) {
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] == target) {
        //         return i;
        //     }
        // }
        if(arr.length == 0)
            return -1;
        
        int i=0;
        int j=arr.length-1;
        int res = -1;
        while(i<=j){
            if(arr[i]==target){
                return i;
            }
            if(arr[j]==target){
                res = j;
            }
            i++;
            j--;
        
        }
        return res;
    }

    public static int findlastoccurance(int[] arr, int target) {
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] == target) {
        //         return i;
        //     }
        // }
        if(arr.length == 0)
            return -1;
        
        int i=0;
        int j=arr.length-1;
        int res = -1;
        while(i<=j){
            if(arr[i]==target){
                res = i;
            }
            if(arr[j]==target){
                return j;
            }
            i++;
            j--;
        
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 4, 1, 3};
        System.out.println(findfirstoccurance(arr, 3));
        System.out.println(findlastoccurance(arr, 3));
    }
}
