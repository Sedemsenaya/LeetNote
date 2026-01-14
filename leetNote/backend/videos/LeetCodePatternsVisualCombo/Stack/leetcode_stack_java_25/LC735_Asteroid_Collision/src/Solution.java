import java.util.*;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int a : asteroids) {
            boolean alive = true;
            while (alive && a < 0 && !st.isEmpty() && st.peek() > 0) {
                int b = st.peek();
                if (b < -a) st.pop();
                else if (b == -a) { st.pop(); alive = false; }
                else alive = false;
            }
            if (alive) st.push(a);
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) ans[i] = st.pop();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{5,10,-5}))); // [5,10]
    }
}
