public class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) cnt[ch]++;
        int len = 0;
        boolean odd = false;
        for (int c : cnt) {
            len += (c / 2) * 2;
            if ((c & 1) == 1) odd = true;
        }
        return odd ? len + 1 : len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd")); // 7
    }
}
