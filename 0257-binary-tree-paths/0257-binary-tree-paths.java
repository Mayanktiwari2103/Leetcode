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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls=new ArrayList<>();
        path(root,ls,new StringBuilder());
        return ls;

    }
    public void path(TreeNode root,List<String> ls , StringBuilder sb){
        if(root==null) return ;
        int len=sb.length();
        sb.append(root.val );
        if(root.left==null && root.right==null){
            ls.add(sb.toString());

        }
        else{
            sb.append("->");
            path(root.left,ls,sb);
            path(root.right,ls,sb);

        }
        sb.setLength(len);
        
    }
}