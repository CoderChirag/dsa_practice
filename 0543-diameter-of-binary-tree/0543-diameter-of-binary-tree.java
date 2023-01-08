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
    int res = 0;
    public int diameter(TreeNode root, int level){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return level;

        int left = diameter(root.left, level+1);
        int right = diameter(root.right, level+1);
        if(left == 0) res = Math.max(res, right-level);
        else if(right == 0) res = Math.max(res, left-level);
        else res = Math.max(res, left+right-2*level);
        return Math.max(left, right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        diameter(root, 0);
        return res;
    }
}