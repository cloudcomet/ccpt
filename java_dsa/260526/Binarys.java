public class Binarys {
    public static int binarysearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;
        int ans = -1;
        while(start<=end){
            if(arr[mid]==target){
                ans = mid;
                end = mid-1;
            }
            else if(arr[mid]>target) {
                end=mid-1;
            }
            else start=mid+1;
            mid = (start+end)/2;
            }
        return ans; 
    }

    public static void main(String[] args) {
        System.out.println(binarysearch(new int[]{1, 2, 3, 3, 3, 3, 3, 3, 3}, 10));
    }
}
    

