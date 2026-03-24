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
    public boolean isValidBST(TreeNode root) {
        List<Integer> ls=new ArrayList<>();
        inorder(root,ls);
        for(int i=1;i<ls.size();i++){
            if(ls.get(i-1) >= ls.get(i)){
                return false;
            }
        }
        return true;
    }
    private void inorder(TreeNode root,List<Integer> ls){
        if(root==null) return ;
        inorder(root.left,ls);
        ls.add(root.val);
        inorder(root.right,ls);
    }
}