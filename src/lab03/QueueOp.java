package lab03;

public class QueueOp {
    private final int[] arr;
    private int front; //INDEX OF FRONT ELEMENT
    private int rear;  //INDEX OF LAST ELEMENT
    private int size;  //SIZE OF QUEUE
    private final int maxsize; //MAXIMUM CAPACITY

    // Constructor to initialize the queue with a given capacity
    public QueueOp(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
        front = 0;
        rear = -1;
        size = 0;
    }

    // ADD ELEMENT AT THE END OF QUEUE
    public void enqueue(int item) {
        //CHECK IF FULL
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        //IF NOT FULL, ADD ELEMENT
        rear = (rear + 1) % maxsize; // Circular increment to wrap around if needed
        arr[rear] = item;
        size++;
    }

    //GET FRONT ELEMENT
    public int peek() {
        //CHECK IF EMPTY
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        //IF NOT EMPTY, RETURN FRONT ELEMENT
        return arr[front];
    }

    //REMOVE FRONT ELEMENT
    public int dequeue() {
        //CHECK IF EMPTY
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        //IF NOT EMPTY, REMOVE FRONT ELEMENT
        int removedItem = arr[front];
        front = (front + 1) % maxsize;
        size--;
        return removedItem;
    }

    //CHECK IF QUEUE IS EMPTY
    public boolean isEmpty() {
        return size == 0;
    }

    //CHECK IF QUEUE IS FULL
    public boolean isFull() {
        return size == maxsize;
    }

    //GET CURRENT SIZE OF QUEUE
    public int size() {
        return size;
    }
//-----------------------------------MAIN FUNCTION--------------------------------------
    public static void main(String[] args) {

        //QUEUE WITH MAXSIZE=10
        QueueOp queue = new QueueOp(10);

        //ENQUEUE ELEMENTS
        queue.enqueue(7);
        queue.enqueue(14);
        queue.enqueue(21);
        queue.enqueue(28);

        //DISPLAY QUEUE SIZE
        System.out.println("Queue size: " + queue.size());

        //DISPLAY FRONT ELEMENT
        System.out.println("Front element: " + queue.peek());

        //DISPLAY DEQUEUED ELEMENTS
        System.out.println("Dequeued element: " + queue.dequeue());

        //DISPLAY QUEUE AFTER QUEUEING
        System.out.println("Queue size after dequeue: " + queue.size());
    }
}


