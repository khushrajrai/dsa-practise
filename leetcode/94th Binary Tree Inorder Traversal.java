// 4. Binary Tree Inorder Traversal

// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Explanation:
// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,2,6,5,7,1,3,9,8]
// Explanation:
// Example 3:
// Input: root = []
// Output: []
// Example 4:
// Input: root = [1]
// Output: [1]
// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
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
//Recursive Approach
// class Solution {
//     List<Integer> ans = new ArrayList<>();
//     public List<Integer> inorderTraversal(TreeNode root) {
//         dfs(root);
//         return ans;
//     }
//     void dfs(TreeNode root){
//         if(root==null){
//             return;
//         }
//         dfs(root.left);
//         ans.add(root.val);
//         dfs(root.right);
//     }
// }
//Iterative Approach
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //print all the root (processed root)
            node = stack.pop();
            list.add(node.val);
            //move to right subtree
            node = node.right;
        }
        return list;
    }
}
