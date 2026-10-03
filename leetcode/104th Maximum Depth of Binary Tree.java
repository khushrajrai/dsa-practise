// 104. Maximum Depth of Binary Tree

// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3
// Example 2:
// Input: root = [1,null,2]
// Output: 2
// Constraints:
// The number of nodes in the tree is in the range [0, 104].
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
class Solution {

    public int maxDepth(TreeNode root) {
        //max height - height of a tree
        //DFS Method
        if (root == null) {
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return (1 + Math.max(lh, rh));
    }
}

// class Solution {
//     public int maxDepth(TreeNode root) {
//         //max height - height of a tree
//         //BFS Method
//         if(root==null) return 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         int level=0;
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             while(size>0){
//                 TreeNode node = queue.poll();
//                 if(node.left!=null){
//                     queue.offer(node.left);
//                 }
//                 if(node.right!=null){
//                     queue.offer(node.right);
//                 }
//                 size--;
//             }
//             if(!queue.isEmpty()){
//                 level++;
//             }
//         }
//         return (1+level);
//     }
// }
