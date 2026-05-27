import java.util.Scanner;

class InvalidAgeException extends Exception{

    InvalidAgeException(String message){
    super(message);
    }
}

public class Age {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    try{
    if (input.nextInt() >= 18){
        throw new InvalidAgeException("Invalid age");
    }
    input.close();
    }
    catch (InvalidAgeException e){
        System.out.println(e.getMessage());
    }
    catch (Exception e){
        System.out.println(e.getMessage());
        }
        
    }

}

