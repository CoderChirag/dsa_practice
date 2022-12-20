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
    int max;
    public int findMaxSum(TreeNode root){
        if(root == null) return 0;
        int ls = findMaxSum(root.left);
        int rs = findMaxSum(root.right);
        
        int max_single = Math.max(Math.max(ls, rs)+root.val, root.val);
        int max_top = Math.max(max_single, ls+rs+root.val);
        max = Math.max(max, max_top);
        return max_single;
    }
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findMaxSum(root);
        return max;
    }
}