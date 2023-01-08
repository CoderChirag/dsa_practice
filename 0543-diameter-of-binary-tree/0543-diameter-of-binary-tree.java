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
    public int diameter(TreeNode root){
        if(root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        res = Math.max(res, left+right);
        return Math.max(left, right)+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        diameter(root);
        return res;
    }
}