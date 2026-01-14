public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        int[] need = new int[128];
        for (char ch : t.toCharArray()) need[ch]++;
        int missing = t.length();

        int bestL = 0, bestLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (need[ch] > 0) missing--;
            need[ch]--;

            while (missing == 0) {
                if (r - l + 1 < bestLen) {
                    bestLen = r - l + 1;
                    bestL = l;
                }
                char left = s.charAt(l++);
                need[left]++;
                if (need[left] > 0) missing++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC")); // BANC
    }
}
