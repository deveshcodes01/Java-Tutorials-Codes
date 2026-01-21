package Recursion;

public class GlobalVariables {
    static int x = 10;

    public static void main(String[] args) {
        // fun();
        System.out.println(x);
        int x = 4;
        System.out.println(x);
        x = 6;
    }

    public static void fun() {
        x = 20;
    }

}
