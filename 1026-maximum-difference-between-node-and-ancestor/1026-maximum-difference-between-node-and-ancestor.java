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
    
    public void maxAncestorDiffRec(TreeNode root, int currMin, int currMax){
        if(root == null) return;
        
        int max = Math.max(Math.abs(root.val-currMin), Math.abs(root.val-currMax));
        res = Math.max(res, max);
        currMin = Math.min(currMin, root.val);
        currMax = Math.max(currMax, root.val);
        maxAncestorDiffRec(root.left, currMin, currMax);
        maxAncestorDiffRec(root.right, currMin, currMax);

    }
    
    public int maxAncestorDiff(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxAncestorDiffRec(root, root.val, root.val);
        return res;
    }
}