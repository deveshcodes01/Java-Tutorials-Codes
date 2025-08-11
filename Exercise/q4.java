import java.util.Scanner;

public class q4 {
    public static float Red(float r) {
        double pi = 3.14;
        float c = (float) (2 * pi * r); // type cast
        return c;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter radius of circle: ");
        float r = sc.nextFloat();
        float cir = Red(r);
        System.out.println("circumference of circle is " + cir);
        sc.close();

    }
}
