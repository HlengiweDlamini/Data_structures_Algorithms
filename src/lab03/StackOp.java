package lab03;

public class StackOp {

    public static void main(String[] args) {

        stack st = new stack();
        st.push(7);
        st.push(14);
        st.push(21);
        st.push(28);
        st.push(35);
        System.out.println("Top of the stack: " + st.peek());
        System.out.println("The element deleted: " + st.pop());
        System.out.println("Top of the stack after deleting an element: " + st.peek());
        st.printStack();
    }
}
class stack {
    int size = 50;
    int[] arr = new int[size];
    int top = -1;

    //ADD ELEMENT
    void push(int x) {
        top++;
        arr[top] = x;
    }
    //REMOVE TOP ELEMENT
    int pop() {
        int x = arr[top];
        top--;
        return x;
    }

    //DISPLAY TOP ELEMENT
    int peek() {
        return arr[top];
    }
    void printStack() {
        System.out.print("The final stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}