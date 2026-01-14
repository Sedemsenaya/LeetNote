import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;

        int[] need = new int[26];
        for (char ch : p.toCharArray()) need[ch - 'a']++;
        int missing = p.length();

        int[] win = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int r = s.charAt(i) - 'a';
            win[r]++;
            if (win[r] <= need[r]) missing--;

            if (i >= p.length()) {
                int l = s.charAt(i - p.length()) - 'a';
                if (win[l] <= need[l]) missing++;
                win[l]--;
            }
            if (missing == 0) res.add(i - p.length() + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc")); // [0,6]
    }
}
