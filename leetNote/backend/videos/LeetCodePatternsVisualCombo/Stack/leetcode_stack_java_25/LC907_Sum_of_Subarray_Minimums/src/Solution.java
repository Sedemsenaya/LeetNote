import java.util.*;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] left = new int[n];  // distance to previous strictly less
        int[] right = new int[n]; // distance to next less or equal

        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            left[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            right[i] = st.isEmpty() ? (n - i) : (st.peek() - i);
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3,1,2,4})); // 17
    }
}
