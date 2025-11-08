public class LinearSearch {
    static boolean search(int[] a, int n, int target, int idx) {
        // base case
        if (idx >= n) {
            return false;
        }

        // self work
        if (a[idx] == target) {
            return true;
        }
        // recusive work

        return search(a, n, target, idx + 1);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 6 };
        int target = 4;
        if (search(a, a.length,target, 0)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
         

        // ---OLD SCHOOL APPROACH---
        // int pos = -1;
        // for(int i=0;i<a.length;i++)
        // {
        //     if (a[i] == target) {
        //         pos=i;
        //         break;
        //     }
        // }
        // if (pos == -1) {
        //     System.out.println("search unsuccessful");
        // }
        // else{
        //     System.out.println("element found at "+(pos+1));
        // }
    }
}
