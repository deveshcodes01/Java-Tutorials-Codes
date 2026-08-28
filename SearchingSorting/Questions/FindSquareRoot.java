public class FindSquareRoot {
    static int sqrt(int x) {
        int start = 0, end = x;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = mid * mid;  // use long here to avoid overflow
            if (val == x) {
                return mid;
            } else if (val < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int x = 24;
        System.out.println(sqrt(x));
    }
}
