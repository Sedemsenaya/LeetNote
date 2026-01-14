import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int best = 0;
        for (int l = 0, r = 0; r < fruits.length; r++) {
            cnt.put(fruits[r], cnt.getOrDefault(fruits[r], 0) + 1);
            while (cnt.size() > 2) {
                int f = fruits[l++];
                cnt.put(f, cnt.get(f) - 1);
                if (cnt.get(f) == 0) cnt.remove(f);
            }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[]{1,2,1})); // 3
        System.out.println(new Solution().totalFruit(new int[]{0,1,2,2})); // 3
    }
}
