import java.util.Scanner;
public class Add {
    public static int add(int[] arr) {
        int sum = 0;
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            sum += arr[i];
            if (i != j) {
                sum += arr[j];
            }
            i++;
            j--;
        }
        return sum;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println("Sum of elements: " + add(arr));
    sc.close();
}
}