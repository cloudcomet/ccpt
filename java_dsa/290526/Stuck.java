import java.util.Stack;

public class Stuck {

    public static StringBuilder textEditor(String message, String operation){

        Stack<Character> undo = new Stack<>();
        Stack<Character> redo = new Stack<>();

        for(int i = 0; i < message.length(); i++){
            undo.push(message.charAt(i));
        }


        for (int i = 0; i < operation.length(); i++) {

            char undoRedo = operation.charAt(i);

            // push char in stack
            if (undoRedo == 'U'){
                redo.push(undo.pop());
            }
            else{
                // pop character from stack
                undo.push(redo.pop());
            }
        }
        StringBuilder result = new StringBuilder();

        for (char x : undo){
            result.append(x);
        }

        return result;
    }

    public static void main(String[] args){

        System.out.println(textEditor("Hello", "UURURUUR"));

    }


}