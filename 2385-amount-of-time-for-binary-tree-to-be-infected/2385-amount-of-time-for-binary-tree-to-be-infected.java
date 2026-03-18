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
    TreeNode parentmark(TreeNode root,HashMap<TreeNode , TreeNode > parentmap,int start){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode targetnode=null;
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.val==start){
                targetnode=current;
            }
            if(current.left!=null){
                q.offer(current.left);
                parentmap.put(current.left,current);
            }
            if(current.right!=null){
                q.offer(current.right);
                parentmap.put(current.right,current);
            }
        }
        return targetnode;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode , TreeNode > parentmap=new HashMap<>();
        TreeNode startnode=parentmark(root,parentmap,start);
        HashMap<TreeNode , Boolean> visitedmap=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(startnode);
        visitedmap.put(startnode,true);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            time++;
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(current.left!=null && visitedmap.get(current.left)==null){
                    q.offer(current.left);
                    visitedmap.put(current.left,true);
                }
                if(current.right!=null && visitedmap.get(current.right)==null){
                    q.offer(current.right);
                    visitedmap.put(current.right,true);
                }
                if(parentmap.get(current)!=null && visitedmap.get(parentmap.get(current))==null){
                    q.offer(parentmap.get(current));
                    visitedmap.put(parentmap.get(current),true);
                }
            }
        }
        return time-1;
        
    }
}