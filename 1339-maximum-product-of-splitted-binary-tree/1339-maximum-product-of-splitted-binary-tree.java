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
    
    int MOD = 1_000_000_007;
    long res = 0L;
    public long sum(TreeNode root){
        if(root == null) return 0;
        
        return sum(root.left) + sum(root.right) + root.val;
    }
    
    public long maxProductRec(TreeNode root, long sum){
        if(root == null) return 0;
        
        long subtreeSum = maxProductRec(root.left, sum) + maxProductRec(root.right, sum) + root.val;
        
        long prod = subtreeSum*(sum-subtreeSum);
        res = Math.max(res, prod);
        
        return subtreeSum;
    } 
    
    public int maxProduct(TreeNode root) {
        res = 0L;
        long sum = sum(root);
        maxProductRec(root, sum);
        return (int)(res%MOD);
    }
}