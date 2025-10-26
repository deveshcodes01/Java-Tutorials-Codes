import java.util.Scanner;

public class Rotate {

    static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void transposeInPlace(int[][] matrix, int r, int c)

    {
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void rotate(int[][] matrix, int n) {
        // transpose
        // reverse each row
        transposeInPlace(matrix, n, n);
        for (int i = 0; i < n; i++) {
            /*
             * 1,2,3
             * 4,5,6
             * 7,8,9
             */
            reverseArray(matrix[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of rows and columns of matrix");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        int total = r * c;
        System.out.println("enter " + total + "matrix values");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("input matrix");

        printMatrix(matrix);
        rotate(matrix, r);
        System.out.println("matrix after rotation");
        printMatrix(matrix);
        sc.close();
    }
}
