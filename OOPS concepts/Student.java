/*USING GETTER AND SETTER METHODS \
STUDIED FROM COLLEGE WALLAH */ 
// package OOPS concepts;

public class Student {
    
    public String name;
    private int rno;
    double percent;

    public Student(String naam,int roll,double per)
    {
      name=naam;
      rno=roll;
      percent=per;
    }
    public int getRno()
    {
        return rno;
         
    }
    // public void setRno(int rno)
    // {
    //     this.rno=rno;
    // }
}
