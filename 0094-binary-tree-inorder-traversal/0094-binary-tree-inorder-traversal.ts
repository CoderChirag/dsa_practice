/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
function rec(root: TreeNode | null, res: number[]){
    if(!root)
        return;
    rec(root.left, res);
    res.push(root.val);
    rec(root.right, res);
}

function inorderTraversal(root: TreeNode | null): number[] {
    const arr = [];
    rec(root, arr);
    return arr;
};