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
    private long res;
    private int MOD = 1000000007;
    
    private long treeSum(TreeNode root){
        if(root == null) return 0;
        return root.val + treeSum(root.left) + treeSum(root.right);
    }
    
    private long subtreeSum(TreeNode root, long treeSum){
        if(root == null) return 0;
        long ls = subtreeSum(root.left, treeSum);
        long rs = subtreeSum(root.right, treeSum);
        long a = (treeSum-ls)*ls;
        long b = (treeSum-rs)*rs;
        res = Math.max(res, Math.max(a, b));
        return ls + rs + root.val;
    }
    
    public int maxProduct(TreeNode root) {
        res = 0L;
        subtreeSum(root, treeSum(root));
        return (int)(res % MOD);
    }
}