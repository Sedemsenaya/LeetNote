import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);
        Set<Integer> seen = new HashSet<>();
        for (int c : freq.values()) if (!seen.add(c)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[]{1,2,2,1,1,3})); // true
    }
}
