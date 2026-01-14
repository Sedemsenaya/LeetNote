import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (dead.contains(start)) return -1;
        if (start.equals(target)) return 0;

        ArrayDeque<String> q = new ArrayDeque<>();
        q.add(start);
        Set<String> seen = new HashSet<>();
        seen.add(start);
        int steps = 0;

        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; sz--) {
                String cur = q.poll();
                if (cur.equals(target)) return steps;
                for (String nxt : neighbors(cur)) {
                    if (dead.contains(nxt) || !seen.add(nxt)) continue;
                    q.add(nxt);
                }
            }
            steps++;
        }
        return -1;
    }

    private List<String> neighbors(String s) {
        List<String> res = new ArrayList<>(8);
        char[] a = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char old = a[i];
            a[i] = (char) ((old - '0' + 1) % 10 + '0');
            res.add(new String(a));
            a[i] = (char) ((old - '0' + 9) % 10 + '0');
            res.add(new String(a));
            a[i] = old;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] dead = {"0201","0101","0102","1212","2002"};
        System.out.println(new Solution().openLock(dead, "0202")); // 6
    }
}
