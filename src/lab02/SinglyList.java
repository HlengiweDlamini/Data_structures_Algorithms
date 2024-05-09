package lab02;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class SinglyList {
    private Node head;

    public SinglyList() {
        this.head = null;
    }
//--------------------------------METHODS----------------------------------
    public void insertAtBeginning(int data) {
        head = new Node(data, head);
    }

    public void insertAtEnd(int data) {
        if (head == null) {
            head = new Node(data, null);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data, null);
        }
    }

    public void insert(int data) {
        insertAtEnd(data);
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data, null);
        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

//---------------------------------MAIN FUNCTION-------------------------------------------
    public static void main(String[] args) {
        SinglyList list = new SinglyList();

        list.insert(23);
        list.insert(8);
        list.insert(7);
        list.insert(5);

        System.out.println("Linked List:");
        list.display();

        list.insertAtBeginning(17);
        System.out.println("Linked List after inserting at the beginning:");
        list.display();

        list.insertAtEnd(90);
        System.out.println("Linked List after inserting at the end: ");
        list.display();

        list.insertAtPosition(3, 3);
        System.out.println("Linked List after inserting at position 3: ");
        list.display();

    }
}