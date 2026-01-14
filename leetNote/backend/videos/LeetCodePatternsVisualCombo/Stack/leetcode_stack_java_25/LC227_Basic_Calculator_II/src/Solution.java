import java.util.*;

public class Solution {
    public int calculate(String s) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = s.length();
        int num = 0;
        char op = '+';
        for (int i = 0; i <= n; i++) {
            char ch = (i == n) ? '+' : s.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                if (op == '+') st.push(num);
                else if (op == '-') st.push(-num);
                else if (op == '*') st.push(st.pop() * num);
                else if (op == '/') st.push(st.pop() / num);
                op = ch;
                num = 0;
            }
        }
        int sum = 0;
        while (!st.isEmpty()) sum += st.pop();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2")); // 7
        System.out.println(new Solution().calculate(" 3/2 ")); // 1
    }
}
