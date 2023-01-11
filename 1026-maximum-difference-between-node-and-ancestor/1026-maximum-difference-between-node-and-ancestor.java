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
    
    public int maxAncestorDiffRec(TreeNode root, int currMin, int currMax){
        if(root == null) return currMax - currMin;
        
        currMin = Math.min(currMin, root.val);
        currMax = Math.max(currMax, root.val);
        int ls = maxAncestorDiffRec(root.left, currMin, currMax);
        int rs = maxAncestorDiffRec(root.right, currMin, currMax);
        return Math.max(ls, rs);
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffRec(root, root.val, root.val);
    }
}