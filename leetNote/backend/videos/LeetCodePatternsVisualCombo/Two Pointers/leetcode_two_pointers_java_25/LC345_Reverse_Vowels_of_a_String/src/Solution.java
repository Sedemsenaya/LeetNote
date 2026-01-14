import java.util.*;

public class Solution {
    public String reverseVowels(String s) {
        boolean[] v = new boolean[256];
        for (char ch : "aeiouAEIOU".toCharArray()) v[ch] = true;

        char[] a = s.toCharArray();
        int l = 0, r = a.length - 1;
        while (l < r) {
            while (l < r && !v[a[l]]) l++;
            while (l < r && !v[a[r]]) r--;
            char t = a[l]; a[l] = a[r]; a[r] = t;
            l++; r--;
        }
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello")); // holle
    }
}
