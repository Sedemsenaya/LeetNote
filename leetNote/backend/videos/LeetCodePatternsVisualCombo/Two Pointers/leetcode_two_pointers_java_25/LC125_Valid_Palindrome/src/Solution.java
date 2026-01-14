public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            char a = Character.toLowerCase(s.charAt(l));
            char b = Character.toLowerCase(s.charAt(r));
            if (a != b) return false;
            l++; r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(new Solution().isPalindrome("race a car")); // false
    }
}
