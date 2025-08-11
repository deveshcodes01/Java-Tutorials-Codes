// STUDIED FROM GETTER AND SETTER METHODS
public class StudentClass {
    // creating a new data type
    public static class Student{
        String name;
        int rno;
        double percent;
    }
    // public static class Car{
    //     String name;
    //     String type;
    //     int price;
    // }

    public static void fun(Student x)
    {
        System.out.println(x.name);
        return;
    }
    public static void main(String[] args) {

        // Car c=new Car();

        // c.name="G-Wagon";
        // c.type="SUV";
        // c.price=40000000;

        Student s1=new Student();
        s1.name="devesh";
        s1.rno=19;
        s1.percent=85.7;
        // System.out.println(s1.getRno());
        // System.out.println(s1.percent+8); 
        // s1.setRno(76);

        fun(s1);

    }
}
