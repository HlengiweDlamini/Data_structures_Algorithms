package lab01;

public class MathOp {
    //---------------------------METHODS----------------------------------
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    public static double calculateAvg(int[] arr) {
        int sum = calculateSum(arr);
        return (double) sum / arr.length;
    }
    public static int calculateMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int calculateMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //----------------------------MAIN FUNCTION-------------------------------
    public static void main(String[] args) {

        int[] arr = {2, 7, 9, 3, 7};

        //CALL METHODS
        int sum = calculateSum(arr);
        double avg = calculateAvg(arr);
        int max = calculateMax(arr);
        int min = calculateMin(arr);

        //DISPLAY RESULTS
        System.out.println("Sum: " +sum);
        System.out.println("Average: " +avg);
        System.out.println("Maximum: " +max);
        System.out.println("Minimum: " +min);

    }
}
