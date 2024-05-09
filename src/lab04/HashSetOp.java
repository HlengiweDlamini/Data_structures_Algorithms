package lab04;

import java.util.HashSet;
import java.util.Set;

public class HashSetOp {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();

        //ADD ELEMENTS
        s.add(7);
        s.add(14);
        s.add(21);
        s.add(28);
        s.add(35);

        //REMOVE ELEMENT
        s.remove(28);

        //CHECK IF ELEMENT EXISTS
        System.out.println("Contains 28 after removal: " + s.contains(28));
        System.out.println("Contains 7: " + s.contains(7));

    }
}
