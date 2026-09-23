// 105. Construct Binary Tree from Preorder and Inorder Traversal

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
// Constraints:
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        //hash the values with the indexs
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n = preorder.length;
        int m = inorder.length;
        TreeNode root = constructTree(preorder, inorder, indexMap, 0, n - 1, 0, m - 1);
        return root;
    }

    public TreeNode constructTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> indexMap, int preIndStart, int preIndEnd, int inIndStart, int inIndEnd) {
        //handle the base case
        if (preIndStart > preIndEnd || inIndStart > inIndEnd) {
            return null;
        }
        int rootData = preorder[preIndStart];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);
        int leftTreeSize = rootIndex - inIndStart;
        int rightTreeSize = inIndEnd - rootIndex;
        root.left = constructTree(preorder, inorder, indexMap, preIndStart + 1, preIndStart + leftTreeSize, inIndStart, rootIndex - 1);
        root.right = constructTree(preorder, inorder, indexMap, preIndStart + leftTreeSize + 1, preIndStart + leftTreeSize + rightTreeSize, rootIndex + 1, inIndEnd);
        return root;
    }
}
