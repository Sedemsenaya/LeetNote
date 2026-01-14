import java.util.*;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int x : sorted) if (!rank.containsKey(x)) rank.put(x, r++);

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) ans[i] = rank.get(arr[i]);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().arrayRankTransform(new int[]{40,10,20,30}))); // [4,1,2,3]
    }
}
