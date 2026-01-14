import java.util.*;

public class Solution {
    public int calculate(String s) {
        int n = s.length();
        int res = 0;
        int sign = 1;
        int num = 0;
        ArrayDeque<Integer> st = new ArrayDeque<>(); // push res then sign

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res += sign * num;
                num = 0;
                int prevSign = st.pop();
                int prevRes = st.pop();
                res = prevRes + prevSign * res;
            } else {
                // space
            }
        }
        res += sign * num;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1 + 1")); // 2
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)")); // 23
    }
}
