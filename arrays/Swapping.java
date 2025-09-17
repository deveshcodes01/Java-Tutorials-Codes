public class Swapping {
    static void swap(int a,int b)
    {
        System.out.println("original value before swap");
        System.out.println("a: "+a);
        System.out.println("b: "+b);

        //using temp variable
        int temp=a;
        a=b;
        b=temp;
        // without using temp variable
        a=a+b;
        b=a-b;
        a=a-b;

        System.out.println("values after swap");
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }
    public static void main(String[] args) {
        int a=9;
        int b=3;
        swap(a, b);
    }
}
