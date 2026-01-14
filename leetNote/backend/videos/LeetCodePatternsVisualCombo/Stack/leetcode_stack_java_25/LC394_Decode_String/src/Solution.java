import java.util.*;

public class Solution {
    public String decodeString(String s) {
        ArrayDeque<Integer> countSt = new ArrayDeque<>();
        ArrayDeque<StringBuilder> strSt = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                countSt.push(num);
                strSt.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                int k = countSt.pop();
                StringBuilder prev = strSt.pop();
                for (int i = 0; i < k; i++) prev.append(cur);
                cur = prev;
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c]]")); // accaccacc
    }
}
