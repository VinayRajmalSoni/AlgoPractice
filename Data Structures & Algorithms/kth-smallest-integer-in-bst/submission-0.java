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

class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }
}

public class Solution2 {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (count > (k - 1)) {
            return kthSmallest(root.left, k);
        } else if (count == k - 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k - 1 - count);
        }
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        int count = 1 + countNodes(n.left) + countNodes(n.right);
        memo.put(n, count);
        return count;
    }
}
