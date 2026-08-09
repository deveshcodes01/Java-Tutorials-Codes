package Maps_and_Sets;

import java.util.HashSet;
import java.util.Set;

public class threeSum {

    static boolean hasTripletSum(int[] arr, int target) {
        int n = arr.length;

        // Fix the first element as arr[i]
        for (int i = 0; i < n - 2; i++) {

            // Hash set to store potential second elements
            Set<Integer> st = new HashSet<>();

            // Fix the third element as arr[j]
            for (int j = i + 1; j < n; j++) {
                int second = target - arr[i] - arr[j];

                // Search for second element in hash set
                if (st.contains(second)) {
                    return true;
                }

                // Add arr[j] as a potential second element
                st.add(arr[j]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int target = 13;
        if (hasTripletSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }
}