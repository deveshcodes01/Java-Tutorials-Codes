public class half_pyramid_num {
    public static void main(String args[]) {
        int n = 5;
        // OUTER LOOP
        for (int i = 1; i <= n; i++) {
            // INNER LOOP
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

// OUTPUT

// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5