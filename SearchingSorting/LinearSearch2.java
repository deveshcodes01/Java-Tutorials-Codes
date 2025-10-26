public class LinearSearch2 {

    static void findAllIndex(int[] a, int n, int target, int idx) { // 1,2,3,2,2,3                                                                                // base case
        if (idx >= n) {
            return;
        }

        // self work
        if (a[idx] == target) {
            System.out.println(idx); // print all index where target is found
        }

        // recursive work
        findAllIndex(a, n, target, idx); // 1,3,4
    }

    // find FirstIndex -> return index of target if target present in
    // array,otherwise return -1
    static int findIndex(int[] a, int n, int target, int idx) {
        // base case
        if (idx >= n) {
            return -1;
        }

        // self work
        if (a[idx] == target) {
            return idx;
        }
        // recusive work

        return findIndex(a, n, target, idx + 1);
    }

    // true,false -> based on existence
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
        int[] a = { 1, 2, 4, 4, 4, 5, 6 };
        int target = 4;
        int n = a.length;

        System.out.println(findIndex(a, n, target, 0));

        // if (search(a, a.length,target, 0)) {
        // System.out.println("Found");
        // } else {
        // System.out.println("Not Found");
        // }
        findAllIndex(a, n, target, n);
    }
}
