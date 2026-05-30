class Node<T>{

    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.next = null;
    }
}

class MyQueue<T>{

    private Node<T> front;
    private Node<T> rear;

    // insert element in queue
    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if(this.rear == null){
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public void displayQueue(){
        Node<T> temp = this.front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public boolean isEmpty(){
        return this.front == null;
    }

    public T dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        T data = this.front.data;
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
        return data;
    }

    public T runningRequest(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return this.front.data;
    }
}

public class Queu {

    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue after enqueuing 10, 20, 30:");
        queue.displayQueue();

        System.out.println("\nDequeue element: " + queue.dequeue());
        System.out.println("Queue after dequeuing an element:");
        queue.displayQueue();

        System.out.println("\nRunning request (front element): " + queue.runningRequest());

    }


}