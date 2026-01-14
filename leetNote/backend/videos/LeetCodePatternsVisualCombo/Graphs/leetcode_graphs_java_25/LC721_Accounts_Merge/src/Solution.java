import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(100000); // plenty for demo; LeetCode uses dynamic mapping anyway
        Map<String, Integer> emailId = new HashMap<>();
        Map<String, String> emailName = new HashMap<>();
        int id = 0;

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailName.put(email, name);
                if (!emailId.containsKey(email)) emailId.put(email, id++);
                dsu.union(emailId.get(acc.get(1)), emailId.get(email));
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();
        for (String email : emailId.keySet()) {
            int root = dsu.find(emailId.get(email));
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            String name = emailName.get(emails.get(0));
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);
            res.add(merged);
        }
        return res;
    }

    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n]; r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) {
            while (p[x] != x) { p[x] = p[p[x]]; x = p[x]; }
            return x;
        }
        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (r[pa] < r[pb]) p[pa] = pb;
            else if (r[pa] > r[pb]) p[pb] = pa;
            else { p[pb] = pa; r[pa]++; }
        }
    }

    public static void main(String[] args) {
        List<List<String>> acc = Arrays.asList(
            Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
            Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
            Arrays.asList("Mary","mary@mail.com"),
            Arrays.asList("John","johnnybravo@mail.com")
        );
        System.out.println(new Solution().accountsMerge(acc));
    }
}
