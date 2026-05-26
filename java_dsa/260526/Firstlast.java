public class Firstlast {

    // bruteforce approach

    // public static int findfirstoccurance(int[] arr, int target) {
    //     // for (int i = 0; i < arr.length; i++) {
    //     //     if (arr[i] == target) {
    //     //         return i;
    //     //     }
    //     // }
    //     if(arr.length == 0)
    //         return -1;
        
    //     int i=0;
    //     int j=arr.length-1;
    //     int res = -1;
    //     while(i<=j){
    //         if(arr[i]==target){
    //             return i;
    //         }
    //         if(arr[j]==target){
    //             res = j;
    //         }
    //         i++;
    //         j--;
        
    //     }
    //     return res;
    // }

    // public static int findlastoccurance(int[] arr, int target) {
    //     // for (int i = 0; i < arr.length; i++) {
    //     //     if (arr[i] == target) {
    //     //         return i;
    //     //     }
    //     // }
    //     if(arr.length == 0)
    //         return -1;
        
    //     int i=0;
    //     int j=arr.length-1;
    //     int res = -1;
    //     while(i<=j){
    //         if(arr[i]==target){
    //             res = i;
    //         }
    //         if(arr[j]==target){
    //             return j;
    //         }
    //         i++;
    //         j--;
        
    //     }
    //     return res;
    // }

    // public static int[] findfirstandlastoccurance(int[] arr, int target) {
    //     int[] result = new int[2];
    //     result[0] = findfirstoccurance(arr, target);
    //     result[1] = findlastoccurance(arr, target);
    //     if(result[0]==result[1]){
    //         result[0] = -1;
    //         result[1] = -1;
    //     }
    //     return result;
    // }

    //sirs approach using less space complexity

    public static int[] findFirstAndLastOccurrence(int[] arr, int target){
        int first = -1;
        int last = -1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            if(arr[start] == target)
                first = start;
            if(arr[end] == target)
                last = end;
            if(first==-1)
                start++;
            if(last==-1)
                end--;
            if(first != -1 && last != -1 && first!=last)
                return new int[]{first, last};
        }
        return new int[]{first, last};
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 4, 1, 4};
        System.out.println(java.util.Arrays.toString(findFirstAndLastOccurrence(arr, 3)));
    }




}
