package lab01;

import java.util.Arrays;

public class ReverseArray {
    //--------------------------------METHOD----------------------------------
    public static void reverseArray(int[] arr) {
        int left = 0; //BEGINNING OF ARRAY
        int right = arr.length - 1; //INDICATES END OF ARRAY

        //ITERATE UNTIL POINTERS MEET
        while (left < right) {
            //TEMPORARILY STORE VALUE OF START
            int temp = arr[left];

            arr[left] = arr[right]; //MOVES VALUE FROM RIGHT TO LEFT
            arr[right] = temp;

            //MOVE TOWARDS CENTER
            left++; //MOVE POINTER FORWARD TOWARDS END
            right--; //MOVE POINTER BACKWARD TOWARD BEGINNING
        }
    }

    //-------------------------------MAIN FUNCTION-------------------------------
    public static void main(String[] args) {

        int[] arr ={2, 8, 1, 78, 14, 90};

        //DISPLAY THE ARRAY
        System.out.println("Original array: " + Arrays.toString(arr));

        //REVERSE THE ARRAY
        reverseArray(arr);

        //DISPLAY REVERSED ARRAY
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}
