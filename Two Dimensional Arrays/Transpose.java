import java.util.Scanner;
public class Transpose {
         static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] findTranspose(int[][] matrix,int r,int c)
    {
        int[][] ans=new int[c][r];
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                ans[i][j]=matrix[j][i];
            }
        }
        return ans;
    }
    static void transposeInPlace(int[][] matrix,int r,int c)
    {
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                // swap matrix[i][j] and matrix[j][i]
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of rows");
        int r = sc.nextInt();
        System.out.println("enter number of columns");
        int c = sc.nextInt();
        int[][] matrix = new int[r][c]; // total=r*c
        System.out.println("Enter matrix values");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("matrix before transpose");
        printMatrix(matrix);
        System.out.println("transpose of matrix");
        // findTranspose(matrix,r,c);
        transposeInPlace(matrix, r, c);
        printMatrix(matrix);
        sc.close();

        
    }
}
