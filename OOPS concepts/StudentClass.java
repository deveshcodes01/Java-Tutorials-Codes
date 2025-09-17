// STUDIED FROM COLLEGE WALLAH
public class StudentClass {
    // creating a new data type
    public static class Student {
        String name;
        int rno;
        double percent;

        public Student(String name, int rno, double percent) {
            this.name = name;
            this.rno = rno;
            this.percent = percent;
        }

        public static void change(Student s) {
            s.name = "rohan";
        }
    }
    // public static class Car{
    // String name;
    // String type;
    // int price;
    // }

    // public static void fun(Student x)
    // {
    // System.out.println(x.name);
    // return;
    // }
    public static void main(String[] args) {

        // Car c=new Car();

        // c.name="G-Wagon";
        // c.type="SUV";
        // c.price=40000000;

        // Student s1=new Student();
        // s1.name="devesh";
        // s1.rno=19;
        // s1.percent=85.7;
        // // System.out.println(s1.getRno());
        // // System.out.println(s1.percent+8);
        // // s1.setRno(76);

        // fun(s1);

        // for constructors
        Student s1 = new Student("Devesh", 76, 92.1);
        System.out.println(s1.name);
        System.out.println(s1.rno);
        System.out.println(s1.percent);

        Student s2 = new Student("rahul", 45, 88.5);
        System.out.println(s2.name);
        System.out.println(s2.rno);
        System.out.println(s2.percent);
    }
}
