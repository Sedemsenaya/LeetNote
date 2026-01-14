import java.util.*;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i), b = t.charAt(i);
            if (m1[a] != m2[b]) return false;
            m1[a] = i;
            m2[b] = i;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("egg", "add")); // true
        System.out.println(new Solution().isIsomorphic("foo", "bar")); // false
    }
}
