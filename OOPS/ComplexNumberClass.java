class ComplexNumber {
    double x;
    double y;

    ComplexNumber(double x, double y) { // constructor
        this.x = x;
        this.y = y;
    }

    void print() {
        if (y >= 0)
            System.out.println(x + " + " + y + "i");
        else
            System.out.println(x + " - " + (-y) + "i");
    }

    void add(ComplexNumber z) {
        // z.x = 8; // alters value
        x += z.x;
        y += z.y;
    }

    void multiply(ComplexNumber z) {
        x = x * z.x - y * z.y;
        y = x * z.y + y * z.y;
    }
    void divide(ComplexNumber z)
    {

    }
}

public class ComplexNumberClass {
    public static void main(String[] args) {
        ComplexNumber z1 = new ComplexNumber(2, -5);
        ComplexNumber z2 = new ComplexNumber(3, 4);
        z1.print();
        z2.print();
        z1.add(z2);
        z1.print();
        z2.print();
        z1.multiply(z2);
        z1.print();
        z2.print();
    }
}
