package lab02;

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class CustomDoubly {
    private int counter;
    private DoublyNode head;
    private DoublyNode tail;

    CustomDoubly() {
        this.counter = 0;
        this.head = null;
        this.tail = null;
    }

    void insert(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        counter++;
    }

    void display() {
        System.out.println("Number of elements= " + counter);
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CustomDoubly list = new CustomDoubly();

        //INSERT ELEMENTS
        list.insert(7);
        list.insert(14);
        list.insert(21);
        list.insert(28);

        list.display();
    }
}

