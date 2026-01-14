import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]); // height desc
            return Integer.compare(a[1], b[1]); // k asc
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] p = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(new Solution().reconstructQueue(p)));
    }
}
