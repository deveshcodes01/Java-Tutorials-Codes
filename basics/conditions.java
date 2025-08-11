import java.util.*;

public class conditions {  // Class name should follow PascalCase convention

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // No extra braces needed

        int age = sc.nextInt();
        if (age > 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Not Adult");
        }

        sc.close(); // Close Scanner to avoid resource leak
    }
}
