import java.util.*;

class Student{
String name;
int rno;
double cgpa;
void print(){
           System.out.println(name+" "+rno+" "+cgpa);
        }
public class UserDefinedDataType{

    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();
        s1.name = "khushi";
        s1.rno = 23;
        s1.cgpa = 8.5;
        
        Student s2 = new Student();
        s2.name = "rajesh";
        s2.rno = 44;
        s2.cgpa = 7.8;
    
        Student s3 = new Student();
        s3.name = "priya";
        s3.rno = 69;
        s3.cgpa = 6.8;
        
        s1.print();
        s2.print();
        s3.print();
    }
}
}