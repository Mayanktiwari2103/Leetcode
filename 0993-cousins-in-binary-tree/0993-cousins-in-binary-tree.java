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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int depth=0;
        boolean foundx=false;
        boolean foundy=false;
        while(!q.isEmpty()){
            int level=q.size();
            
            for(int i=0;i<level;i++){
               TreeNode curr=q.poll();
               if(curr.left!=null && curr.right!=null){
                if((curr.left.val==x || curr.left.val==y) && (curr.right.val==x || curr.right.val==y)){
                    return false;
                }
                
               }
               if(curr.val==x) foundx=true;
               if(curr.val==y) foundy=true;
               
               if(curr.left!=null) q.add(curr.left);
               if(curr.right!=null) q.add(curr.right);

            }
            if(foundx && foundy) return true;
            if(foundx || foundy) return false; 
        }
        return false;
    }
}