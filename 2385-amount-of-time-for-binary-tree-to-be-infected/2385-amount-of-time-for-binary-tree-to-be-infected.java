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
    TreeNode parentmark(TreeNode root, Map<TreeNode,TreeNode> parent,int start){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode target=null;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.val==start){
                target=curr;
            }
            if(curr.left!=null ){
                parent.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null ){
                parent.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        return target;
    }
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        TreeNode startnode=parentmark(root,parent,start);
        q.add(startnode);
        visited.put(startnode,true);
        int time=0;
        while(!q.isEmpty()){
           time++;
           int size=q.size();
           for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
            if(curr.left!=null && visited.get(curr.left)==null){
                q.add(curr.left);
                visited.put(curr.left,true);
            }
            if(curr.right!=null && visited.get(curr.right)==null){
                q.add(curr.right);
                visited.put(curr.right,true);
            }
            if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                q.add(parent.get(curr));
                visited.put(parent.get(curr),true);
            }

           }
        }

        return time-1;
    }
}