// ENCAPSULATION //

public class Encaps {
    public static void main(String args[])
    {
      Student stu=new Student("devesh",765534);
      System.out.println(stu.getName());
      System.out.println(stu.getRollNo());
    }
}
class Student{
    private String name;
    private int rollNo;

    Student(String name,int rollNo)
    {
        this.name=name;
        this.rollNo=rollNo;
    }
    public String getName(){
        return name;
    }
    public void setName(String name)
     {
    this.name=name;
     }

    public int getRollNo() {
        return rollNo;
    }
}


