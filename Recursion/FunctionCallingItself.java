package Recursion;

import java.util.Scanner;

public class FunctionCallingItself {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number");
        int n=sc.nextInt();
        print(n);
    }
    public static void print(int n)
    {
        if(n==0) return;
        System.out.println(n);
        print(n-1);
    }
}

// continue watching from 20:19