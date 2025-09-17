import java.util.Scanner;

public class Addition {
    static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void add(int[][] a, int r1, int c1, int[][] b, int r2, int c2) {
        if (r1 != r2 || c1 != c2) {
            System.out.println("wrong input-Addition not possible");
            return;
        }
        int[][] sum = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.print("sum of matrix 1 and matrix 2");
        printMatrix(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of rows");
        int r1 = sc.nextInt();
        System.out.println("enter number of columns");
        int c1 = sc.nextInt();
        int[][] a = new int[r1][c1]; // total=r*c
        System.out.println("Enter matrix values");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter number of rows and cloumns");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] b = new int[r2][c2];
        System.out.println("enter matrix values");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println("matrix 1");
        printMatrix(a); // This line is now active
        System.out.println("matrix 2");
        printMatrix(b);

        add(a, r1, c1, b, r2, c2);
        sc.close();
    }
}
