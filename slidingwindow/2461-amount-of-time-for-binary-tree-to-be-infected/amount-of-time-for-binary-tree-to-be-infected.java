/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        // Convert the binary tree into a graph representation
        convertIntoGraph(root, null);

        int minTime = -1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Start BFS from the given start node
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int size = q.size(); // Track the level size for BFS
            minTime++;

            for (int i = 0; i < size; i++) {
                int val = q.poll();
                Set<Integer> neighbors = map.get(val);

                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        q.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        return minTime;
    }

    public void convertIntoGraph(TreeNode root, TreeNode parent) {
        if (root == null) return;

        // Add the current node to the graph if not already present
        map.putIfAbsent(root.val, new HashSet<>());

        // Add edges between the current node and its parent/children
        if (parent != null) {
            map.get(root.val).add(parent.val);
            map.get(parent.val).add(root.val);
        }
        if (root.left != null) {
            map.get(root.val).add(root.left.val);
            map.putIfAbsent(root.left.val, new HashSet<>());
            map.get(root.left.val).add(root.val);
        }
        if (root.right != null) {
            map.get(root.val).add(root.right.val);
            map.putIfAbsent(root.right.val, new HashSet<>());
            map.get(root.right.val).add(root.val);
        }

        // Recursively process the left and right subtrees
        convertIntoGraph(root.left, root);
        convertIntoGraph(root.right, root);
    }
}
