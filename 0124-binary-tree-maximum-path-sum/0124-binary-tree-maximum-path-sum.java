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
        sums(root);
        return sum;
    }
    int sums(TreeNode root){
        int maxsum=0;
        if(root==null) return 0;
        int left=sums(root.left);   
        if(left<0) left=0;      
        int right=sums(root.right);
        if(right<0) right=0;
        sum=Math.max(sum,root.val+left+right);
        maxsum=root.val+Math.max(left,right);
        return maxsum;
    }
}