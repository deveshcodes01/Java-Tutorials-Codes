import java.util.Scanner;

public class updateBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt(); // 1 for set, 0 for clear
        int n = 5; // 0101
        int pos = 1;
        // set operation
        int bitMask = 1 << pos; // 0010
        if (op == 1) {
            int newNumber = bitMask | n;
            System.out.println(newNumber);
        } else {
            int newBitMask = ~(bitMask);
            int newNumber = newBitMask & n;
            System.out.println(newNumber);
        }
        sc.close();
    }
}