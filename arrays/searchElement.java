// CODE 1   
// import java.util.Scanner;
// public class searchElement {
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         int size=sc.nextInt();
//         int numbers[]=new int[size];

//         // input
//         for(int i=0;i<size;i++){
//             numbers[i]=sc.nextInt();
//         }
//         int x=sc.nextInt();

//         // output
//         for(int i=0;i<numbers.length;i++)
//         {
//             if(numbers[i]==x){
//                 System.out.println("Element found at index: "+i);
//                 break;
//             }
//         }
//         sc.close();
//     }
// }

// CODE 2 FOR LINEAR SEARCH AS WELL AS FIRST OCCURENCE OF AN ELEMENT

public class searchElement {

    void searchInArray() {
        int arr[] = { 10, 5, 3, 6, 2, 8, 4 };
        int x = 3;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                ans = i;
                break;
            }
        }
        if (ans == -1) {
            System.out.println("not found");
        } else {
            System.out.println("found " + x + "at index" + ans);
        }
    }
}
