/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void parentmark(TreeNode root, Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                parent.put(current.left,current);
                q.add(current.left);
            }
            if(current.right!=null){
                parent.put(current.right,current);
                q.add(current.right);
            }

        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ls=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        parentmark(root,parent);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        int dist=0;
        q.add(target);
        visited.put(target,true);
        while(!q.isEmpty()){
            if(dist==k) break;
            dist++;
            int size=q.size();
            for(int i=0;i<size;i++){
               TreeNode p=q.poll();
               if(p.left!=null && visited.get(p.left)==null){
                 q.add(p.left);
                 visited.put(p.left,true);

               }
               if(p.right!=null && visited.get(p.right)==null){
                  q.add(p.right);
                  visited.put(p.right,true);
               }

               if(parent.get(p)!=null && visited.get(parent.get(p))==null){
                q.add(parent.get(p));
                visited.put(parent.get(p),true);
               }
            }
        }
        while(!q.isEmpty()){
            ls.add(q.poll().val);
        }
        return ls;

    }
}