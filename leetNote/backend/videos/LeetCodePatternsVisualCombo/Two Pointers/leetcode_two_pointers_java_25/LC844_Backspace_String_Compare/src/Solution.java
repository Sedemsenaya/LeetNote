public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            i = nextValidIndex(s, i);
            j = nextValidIndex(t, j);
            if (i < 0 || j < 0) return i == j;
            if (s.charAt(i) != t.charAt(j)) return false;
            i--; j--;
        }
        return true;
    }

    private int nextValidIndex(String s, int i) {
        int back = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#') { back++; i--; }
            else if (back > 0) { back--; i--; }
            else break;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(new Solution().backspaceCompare("a#c", "b"));     // false
    }
}
