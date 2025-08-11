import java.util.Scanner;

public class q8 {
    public static int Power(int x,int n)
    {
        int exp;
        if (x>0 && n>0) {
            exp=x^n;
            return exp;
        }else if (x<0 && n<0) {
        exp=x^n;
        return exp;  
        }
    else{return 0;}
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int x,n;
        System.out.println("enter value of x and n: ");
        x=sc.nextInt();
        n=sc.nextInt();
        int exp=Power(x, n);
        System.out.println("power is: "+exp);
        sc.close();
    }

  
}

// firse krna hai isko
