package Maps_and_Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Arrays;

class fourSum {
    static ArrayList<ArrayList<Integer>> fSum(int[] arr, int target) {
        int n = arr.length;
        
        // Use a set to avoid duplicate
        // quadruplets
        Set<ArrayList<Integer>> resSet = new HashSet<>();

        // Generate all triplets and check 
        // for the fourth element
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                // Use a hash set to look up the
                // needed fourth element
                Set<Integer> s = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    int last = target - sum;
                    
                    if (s.contains(last)) {
                        ArrayList<Integer> curr = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], last));
                        
                        // Sort to ensure uniqueness
                        Collections.sort(curr);
                        
                        // Set avoids duplicates
                        resSet.add(curr); 
                    }
                    s.add(arr[k]);
                }
            }
        }

        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int target = 23;
        
        ArrayList<ArrayList<Integer>> ans = fSum(arr, target);
        for (ArrayList<Integer> v : ans) {
            for (int x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
