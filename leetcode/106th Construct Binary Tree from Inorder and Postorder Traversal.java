// 106. Construct Binary Tree from Inorder and Postorder Traversal

// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
// Constraints:
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        // hash the values with index
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n = postorder.length - 1;
        int m = inorder.length - 1;
        TreeNode root = constructTree(postorder, inorder, indexMap, 0, n, 0, m);
        return root;
    }

    public TreeNode constructTree(int[] postorder, int[] inorder,
            HashMap<Integer, Integer> indexMap, int postIndStart, int postIndEnd,
            int inIndStart, int inIndEnd) {
        // handle the base case
        if (postIndStart > postIndEnd || inIndStart > inIndEnd) {
            return null;
        }
        int rootData = postorder[postIndEnd];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);
        int leftTreeSize = rootIndex - inIndStart;
        // int rightTreeSize = inIndEnd - rootIndex;
        root.left = constructTree(postorder, inorder, indexMap, postIndStart, postIndStart + leftTreeSize - 1, inIndStart, rootIndex - 1);
        root.right = constructTree(postorder, inorder, indexMap, postIndStart + leftTreeSize, postIndEnd - 1, rootIndex + 1, inIndEnd);
        return root;
    }
}
