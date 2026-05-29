class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Ll {
    
    Node head;

    public void insertAtbeginning(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void displayLl(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public void insertAtend(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public void reverseLl(){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return;
    }

    public static void main(String[] args) {
        Ll obj = new Ll();
        obj.insertAtbeginning(10);
        obj.insertAtend(20);
        obj.insertAtend(30);
        obj.displayLl();
        System.out.println();
        obj.reverseLl();
        obj.displayLl();
    }
}