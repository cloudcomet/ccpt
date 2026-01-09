//average of array
// public static void main(String[] args) {
    //     int[] arr={1,2,3,4,5};
    //     float avg = 0;
    //     int sum = 0;
    //     for(int i:arr){
        //         sum +=i;
        //         avg = (float)sum/arr.length;
        //     }
        //     System.out.println(avg);
        // }
public class Array{
    
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                arr[i]=0;   
                System.out.println(arr);
            }
        }
    }
    
}