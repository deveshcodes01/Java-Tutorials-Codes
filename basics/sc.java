import java.util.*;

public class sc {
    public static void main(String[] args) {  // Corrected main method
        Scanner sc = new Scanner(System.in); // Scanner object

        int n = 1; // Example value for switch-case

        switch(n) {
            case 1 :
                System.out.println("Monday");
                break;
            case 2 :
                System.out.println("Tuesday");
                break;
            case 3 :
                System.out.println("Wednesday");
                break;
            case 4 :
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6 :
                System.out.println("Saturday");
                break;
            default :
                System.out.println("Sunday");
        }

        sc.close(); // Close scanner correctly
    }
}
