public class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) { l++; r--; }
            else return isPal(s, l + 1, r) || isPal(s, l, r - 1);
        }
        return true;
    }

    private boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abca")); // true
        System.out.println(new Solution().validPalindrome("abc"));  // false
    }
}
