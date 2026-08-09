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
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      sum(root);
      return sum;
    } 

    private int sum(TreeNode root){
        if(root==null) return 0;
        int left=sum(root.left);
        int right=sum(root.right);
        if(left<0) left= 0;
        if(right < 0) right= 0;
        sum=Math.max(sum,root.val+left+right);
        return root.val+ Math.max(left,right);
    }  
}