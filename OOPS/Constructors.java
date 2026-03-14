
public class Constructors {
    public static class Car {
        int price;
        // int seats; // 0
        String name; // null
        // double length; // 0.0
        // ---CONSTRUCTOR OVERLOADING--

        Car() {
            // default constructor with no return type
        }

        // Car(int x, String s, double d) { // parameterized constructor
        // Car(int x, String s) {
            // seats = x;
        //     price = x;
        //     name = s;
            // length = d;
        // }
        Car(int price, String name) {
            // seats = x;
            this.price = price;
            this.name = name;
            // length = d;
        }

        Car(String s, int x) {
            this.price = x; 
            name = s;
        }

        void print() {
            int price=12;
            // System.out.println(seats + " " + name + " " + length);
            System.out.println(this.price + " " + name);
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car(1250000, "Innova");
        c1.print();
        Car c2 = new Car("Lord Alto", 40000);
        c2.print();
        Car c3 = new Car();
        c3.name = "Honda City";
    }
}
