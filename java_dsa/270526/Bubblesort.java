// import java.util.Arrays;
public class Bubblesort {

    public static int[] bubblesort(int[] arr){

        for(int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr.length-row-1; col++){

                if (arr[col] > arr[col+1]){
                    int tempVar = arr[col];
                    arr[col] = arr[col+1];
                    arr[col+1] = tempVar;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){

        int[] arr = {3, 2, 1, 6, 0};
        int[] result = bubblesort(arr);

        for(int x : result){
            System.out.println(x);
        }
    }

}

