import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int b = st.pop(), a = st.pop();
                int v;
                switch (t) {
                    case "+": v = a + b; break;
                    case "-": v = a - b; break;
                    case "*": v = a * b; break;
                    default:  v = a / b; break;
                }
                st.push(v);
            } else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2","1","+","3","*"})); // 9
    }
}
