import java.util.*;

public class Solution {
    static class MinStack {
        private ArrayDeque<Integer> st = new ArrayDeque<>();
        private ArrayDeque<Integer> mn = new ArrayDeque<>();

        public void push(int val) {
            st.push(val);
            if (mn.isEmpty()) mn.push(val);
            else mn.push(Math.min(val, mn.peek()));
        }

        public void pop() {
            st.pop();
            mn.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return mn.peek();
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2); ms.push(0); ms.push(-3);
        System.out.println(ms.getMin()); // -3
        ms.pop();
        System.out.println(ms.top());    // 0
        System.out.println(ms.getMin()); // -2
    }
}
