
import java.util.ArrayList;

public class WrapperClass {
    public static void main(String[] args) {
        Integer in = Integer.valueOf(10);
        System.out.println(in);
        Float f = Float.valueOf(4.5f);
        System.out.println(f);

        ArrayList<Integer> l1 = new ArrayList<>();

        // add elements
        l1.add(5); // 5
        l1.add(6); // 5 6
        l1.add(7); // 5 6 7
        l1.add(8); // 5 6 7 8

        // get an element at index i
        System.out.println(l1.get(1));

        // print with for loop
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }

        // print the arrylist directly
        System.out.println(l1);

        // adding element at index i
        l1.add(1, 100);
        System.out.println(l1);

        // modifying element at index i
        l1.set(1, 10);
        System.out.println(l1);

        // remove an element at index i
        l1.remove(1);
        System.out.println(l1);

        // remove an element e
        l1.remove(1);
        System.out.println(l1);

        // checkin if an element is present
        boolean ans = l1.contains(Integer.valueOf(100));
        System.out.println(ans);

        // if you dont specify class, you can put anything inside
        ArrayList l = new ArrayList();
        l.add("pqres");
        l.add(1);
        l.add(true);
        System.out.println(l);

    }
}
