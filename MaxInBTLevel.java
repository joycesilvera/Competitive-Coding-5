import java.util.*;
import java.util.LinkedList;

//BFS
// Time Complexity : O(n) where n is the number of nodes in the binary tree
// Space Complexity : O(n) for the queue used in BFS traversal
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class MaxInBTLevel {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxOfLevels = new ArrayList();
        if (root == null)
            return maxOfLevels;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                maxVal = Math.max(maxVal, currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            maxOfLevels.add(maxVal);
        }

        return maxOfLevels;
    }
}

// DFS
// Time Complexity : O(n) where n is the number of nodes in the binary tree
// Space Complexity : O(h) where h is the height of the binary tree, which can
// be O(n) in the worst case for a skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class DFSSolution {
    List<Integer> result;
    int maxVal = -1;

    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList();
        if (root == null)
            return result;
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int col) {
        // base
        if (root == null)
            return;

        // logic
        if (result.size() > col) { // override max
            maxVal = Math.max(result.get(col), root.val);
            result.set(col, maxVal);
        } else {
            result.add(root.val);
        }

        dfs(root.left, col + 1);
        dfs(root.right, col + 1);
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
