public class invHP_numbers {
    public static void main(String args[]) {
        int n = 7;
        // OUTER LOOP
        for (int i = 1; i <= n; i++) {
            // INNER LOOP
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

// OUTPUT
// 1 2 3 4 5 6 7 
// 1 2 3 4 5 6 
// 1 2 3 4 5 
// 1 2 3 4 
// 1 2 3 
// 1 2 
// 1