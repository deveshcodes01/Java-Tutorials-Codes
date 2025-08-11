public class Floyds_triangle {
    public static void main(String args[]) {
        int p =5;
        int num = 1;
        // OUTER LOOP
        for (int i = 1; i <= p; i++) {
            // INNER LOOP
            for (int j = 1; j <= i; j++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
}

// OUTPUT

// 1  
// 2 3 
// 4 5 6 
// 7 8 9 10 
// 11 12 13 14 15 