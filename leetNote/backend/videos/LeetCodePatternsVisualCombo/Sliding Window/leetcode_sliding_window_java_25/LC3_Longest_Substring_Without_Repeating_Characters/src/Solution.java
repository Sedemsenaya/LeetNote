import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int best = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (last.containsKey(ch)) l = Math.max(l, last.get(ch) + 1);
            last.put(ch, r);
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb")); // 3
    }
}
