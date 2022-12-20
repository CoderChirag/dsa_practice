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
//     private int max_diff;
//     private class Pair{
//         public int min;
//         public int max;
//         public Pair(int min, int max){
//             this.min = min;
//             this.max = max;
//         }
//     }
//     private Pair findMaxDiff(TreeNode root){
//         if(root.left == null && root.right == null) return new Pair(root.val, root.val);
//         Pair res = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
//         if(root.left != null){
//             Pair ls = findMaxDiff(root.left);
//             res.min = Math.min(ls.min, root.val);
//             res.max = Math.max(ls.max, root.val);
//             max_diff = Math.max(max_diff, Math.max(Math.abs(ls.min-root.val), Math.abs(ls.max-root.val)));
//         }
//         if(root.right != null){
//             Pair rs = findMaxDiff(root.right);
//             res.min = Math.min(res.min, Math.min(rs.min, root.val));
//             res.max = Math.max(res.max, Math.max(rs.max, root.val));
//             max_diff = Math.max(max_diff, Math.max(Math.abs(rs.min-root.val), Math.abs(rs.max-root.val)));
//         }
//         return res;
        
//     }
    
    // public int maxAncestorDiff(TreeNode root) {
    //     max_diff = Integer.MIN_VALUE;
    //     findMaxDiff(root);
    //     return max_diff;
    // }
    
    private int findMaxDiff(TreeNode root, int currMax, int currMin){
        if(root == null) return currMax - currMin;
        currMax = Math.max(currMax, root.val);
        currMin = Math.min(currMin, root.val);
        int left = findMaxDiff(root.left, currMax, currMin);
        int right = findMaxDiff(root.right, currMax, currMin);
        return Math.max(left, right);
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return findMaxDiff(root, root.val, root.val);
    }
}