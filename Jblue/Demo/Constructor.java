// import java.util.*;
public class Constructor{
public static class Car{
    int price;
    String name;
    Car(){
        // default constructor
    }
    
    Car(int x,String s){ //parameterized constructor
        price = x;
        name = s;
    }
}


    public static void main(String args[])
    {
        //Scanner sc = new Scanner(System.in);
        Car c1 = new Car(1250000,"Innova");
    }
}