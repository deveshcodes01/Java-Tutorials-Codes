package Maps_and_Sets;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets2 {
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int maXFruits = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < n; right++) {
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);
            while (countMap.size() > 2) {
                int leftFruit = fruits[left];
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);
                if (countMap.get(leftFruit) == 0) {
                    countMap.remove(leftFruit);
                }
                left++;
            }
            maXFruits = Math.max(maXFruits, right - left + 1);
        }
        return maXFruits;
    }

    public static void main(String[] args) {
        int[] fruit = { 1,2,3,2,2 };
        int ans = totalFruit(fruit);
        System.out.println("maximum fruits you can pick is " + ans);

    }
}
