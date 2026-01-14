import java.util.*;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int j = 0;
        for (int x : pushed) {
            st.push(x);
            while (!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        return j == popped.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1})); // true
        System.out.println(new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2})); // false
    }
}
