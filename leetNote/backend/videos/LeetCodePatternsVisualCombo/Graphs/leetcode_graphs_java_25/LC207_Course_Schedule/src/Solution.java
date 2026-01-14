import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.add(i);

        int taken = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            taken++;
            for (int v : g.get(u)) {
                if (--indeg[v] == 0) q.add(v);
            }
        }
        return taken == numCourses;
    }

    public static void main(String[] args) {
        int[][] pre = {{1,0},{0,1}};
        System.out.println(new Solution().canFinish(2, pre)); // false
    }
}
