package lab02;

import java.util.LinkedList;

public class ReverseList {

    //METHOD TO REVERSE LIST
    public static void reverse(LinkedList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            //SWAP
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    //MAIN FUNCTION
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        //INSERT ELEMENTS
        list.add(17);
        list.add(9);
        list.add(8);
        list.add(15);


        System.out.println("Original Linked List:");
        System.out.println(list);

        //REVERSE LIST
        reverse(list);

        System.out.println("Reversed Linked List:");
        System.out.println(list);
    }
}

