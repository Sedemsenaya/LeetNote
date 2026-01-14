public class Solution {
    public int longestSubstring(String s, int k) {
        int best = 0;
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] cnt = new int[26];
            int unique = 0, atLeastK = 0;
            for (int l = 0, r = 0; r < s.length(); r++) {
                int idx = s.charAt(r) - 'a';
                if (cnt[idx] == 0) unique++;
                cnt[idx]++;
                if (cnt[idx] == k) atLeastK++;

                while (unique > targetUnique) {
                    int li = s.charAt(l) - 'a';
                    if (cnt[li] == k) atLeastK--;
                    cnt[li]--;
                    if (cnt[li] == 0) unique--;
                    l++;
                }
                if (unique == targetUnique && unique == atLeastK) best = Math.max(best, r - l + 1);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("aaabb", 3)); // 3
    }
}
