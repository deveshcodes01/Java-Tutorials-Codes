import java.util.*;

public class PassingClassesToMethods
{
    public static class Car{
    int seats;
    String name;
    double length;
    String type;
    int torque;
    
    void print(){
        System.out.println(seats+" "+name+" "+length+"m"+" "+type+" "+torque+"nm ");
    }
}
    public static void main(String[] args)
    {
        Car c = new Car();
        c.seats = 7;
        c.name = "Innova crysta";
        c.length = 4.11;
        c.type = "SUV";
        c.torque = 200;
        
        
        c.print();
    }
}