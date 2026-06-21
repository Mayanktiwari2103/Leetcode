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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls=new ArrayList<>();
        right(ls,root,0);
        return ls;

    }

    private void right(List<Integer> ls,TreeNode root,int level){
        if(root==null) return;
        if(level==ls.size()){
            ls.add(root.val);
        }
        right(ls,root.right,level+1);
        right(ls,root.left,level+1);
    }
    
    
}