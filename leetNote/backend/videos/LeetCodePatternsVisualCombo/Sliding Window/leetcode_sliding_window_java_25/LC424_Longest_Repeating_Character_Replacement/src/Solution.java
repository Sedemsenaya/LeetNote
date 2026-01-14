public class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int best = 0, maxFreq = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            int idx = s.charAt(r) - 'A';
            cnt[idx]++;
            maxFreq = Math.max(maxFreq, cnt[idx]);

            while ((r - l + 1) - maxFreq > k) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("AABABBA", 1)); // 4
    }
}
