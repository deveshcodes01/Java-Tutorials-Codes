package Maps_and_Sets;
// STL-STANDARD TEMPLATE LIBRARY

import java.util.HashSet;

public class sets_STL {
    public static void main(String[] args) {

        // TreeSet<Integer> set = new TreeSet<>(); balanced BST
        HashSet<Integer> set = new HashSet<>();
        set.add(77);
        set.add(65);
        set.add(2);
        set.add(2);
        set.add(11);
        set.add(45);
        set.add(3);
        set.add(77);
        // for(int ele:set) System.out.print(ele+" ");
        // for(int ele:set)
        // {
        // set.remove(ele); //error
        // }
        for (int ele : set) {
            System.out.print(ele + " ");
        }
        set.clear();
        System.out.println();
        for (int ele : set) {
            System.out.println(ele + " ");
        }
    }
}