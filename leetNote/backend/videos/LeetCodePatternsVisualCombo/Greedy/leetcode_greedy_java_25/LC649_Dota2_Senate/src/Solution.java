import java.util.*;

public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        ArrayDeque<Integer> r = new ArrayDeque<>();
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') r.add(i);
            else d.add(i);
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll();
            int di = d.poll();
            if (ri < di) r.add(ri + n);
            else d.add(di + n);
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().predictPartyVictory("RDD")); // Dire
    }
}
