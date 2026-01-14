import java.util.*;

public class Solution {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() { val = 0; neighbors = new ArrayList<>(); }
        public Node(int _val) { val = _val; neighbors = new ArrayList<>(); }
        public Node(int _val, ArrayList<Node> _neighbors) { val = _val; neighbors = _neighbors; }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node cur, Map<Node, Node> map) {
        if (map.containsKey(cur)) return map.get(cur);
        Node copy = new Node(cur.val);
        map.put(cur, copy);
        for (Node nei : cur.neighbors) copy.neighbors.add(dfs(nei, map));
        return copy;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.neighbors.add(b);
        b.neighbors.add(a);
        Node c = new Solution().cloneGraph(a);
        System.out.println(c.val + " neighbors=" + c.neighbors.size()); // 1 neighbors=1
    }
}
