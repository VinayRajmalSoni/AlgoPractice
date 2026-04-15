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

public class Codec {
    // used to split each node, this and the next one need not be private static final
    private static final String spliter = ",";
    // used to represent null value
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    
    // preorder traversal
    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            // this will also happen for a lead node whose left and right child are NULL
            sb.append(NN).append(spliter);
        } else {
            // preorder depth first traversal
            sb.append(node.val).append(spliter);
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Queue<String> nodes) {
        // will remove from front as linked list
        String val = nodes.poll();
        if (val.equals(NN))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
