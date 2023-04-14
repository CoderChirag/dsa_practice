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
    int res = Integer.MIN_VALUE;
    public int maxSum(TreeNode root){
        if(root == null) return 0;
        
        int gainFromLeft = Math.max(maxSum(root.left), 0);
        int gainFromRight = Math.max(maxSum(root.right), 0);
        
        res = Math.max(res, gainFromLeft+gainFromRight+root.val);
        return Math.max(gainFromLeft+root.val, gainFromRight+root.val);
    }
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxSum(root);
        return res;
    }
}