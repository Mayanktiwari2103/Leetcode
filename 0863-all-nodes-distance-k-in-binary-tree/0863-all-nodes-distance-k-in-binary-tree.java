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
    private void parentmark(TreeNode root,HashMap<TreeNode ,TreeNode > parentmap){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                q.offer(current.left);
                parentmap.put(current.left,current);
            }
             if(current.right!=null){
                q.offer(current.right);
                parentmap.put(current.right,current);
            }

        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ls=new ArrayList<>();
        HashMap<TreeNode ,TreeNode > parentmap=new HashMap<>();
        parentmark(root,parentmap);
        HashMap<TreeNode,Boolean> visitedmap=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ls;
        q.offer(target);
        visitedmap.put(target,true);
        int current_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(current_level==k) break;
            current_level++;
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

        while(!q.isEmpty()){
            ls.add(q.poll().val);
        }
        return ls;
        
    }
}