import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int best = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
            while (cnt.size() > 2) {
                char left = s.charAt(l++);
                cnt.put(left, cnt.get(left) - 1);
                if (cnt.get(left) == 0) cnt.remove(left);
            }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("ccaabbb")); // 5
    }
}
