import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>(); // indices, decreasing temps
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        // [1,1,4,2,1,1,0,0]
    }
}
