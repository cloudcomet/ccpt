import java.util.*;
public class java2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter: ");
        String s1 = sc.nextLine();
        
        String[] words = s1.split(" ");
        int s =0;
        for(int i=0; i<words.length; i++){
            s++;
        }
        System.out.println(s);
        
        sc.close();
    }
}