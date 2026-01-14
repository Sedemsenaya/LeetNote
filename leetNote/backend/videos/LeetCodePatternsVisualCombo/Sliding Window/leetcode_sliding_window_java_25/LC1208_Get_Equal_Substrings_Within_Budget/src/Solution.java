public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0, best = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().equalSubstring("abcd", "bcdf", 3)); // 3
    }
}
