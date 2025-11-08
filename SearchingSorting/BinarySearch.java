public class BinarySearch {
    
    static boolean binarySearch(int[] a, int target) {
        int n = a.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == a[mid]) {
                return true;
            } else if (target < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
    static boolean recBinarySearch(int[] a, int start,int end,int target){
        if(start > end)
        {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (target == a[mid]) {
            return true;
        } else if (target < a[mid]) {
            return recBinarySearch(a, start, mid - 1, target);
        } else {
            return recBinarySearch(a, mid + 1, end, target);
        }
    }
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 4;
        while (target != 10) {
            System.out.printf("%d exists in array %b: \n",target, binarySearch(a, target));
            target++;
        }
        // System.out.println(binarySearch(a, target));
    }
}
