import java.util.*;

public class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l]; s[l] = s[r]; s[r] = t;
            l++; r--;
        }
    }

    public static void main(String[] args) {
        char[] a = "hello".toCharArray();
        new Solution().reverseString(a);
        System.out.println(new String(a)); // "olleh"
    }
}
