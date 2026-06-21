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
class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node,int row, int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ls=new ArrayList<>();
       Queue<Tuple> q=new LinkedList<>();
       TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
       q.add(new Tuple(root,0,0));
       while(!q.isEmpty()){
        Tuple p=q.poll();
        TreeNode curr=p.node;
        int rows=p.row;
        int cols=p.col;
        if(!map.containsKey(cols)){
            map.put(cols,new TreeMap<>());
        }
        if(!map.get(cols).containsKey(rows)){
            map.get(cols).put(rows,new PriorityQueue<>());
        }

        map.get(cols).get(rows).add(curr.val);
        if(curr.left!=null){
            q.add(new Tuple(curr.left,rows+1,cols-1));
        }
        if(curr.right!=null){
            q.add(new Tuple(curr.right,rows+1,cols+1));
        }
       }

       for(TreeMap<Integer,PriorityQueue<Integer>> rows:map.values()){
        List<Integer> list=new ArrayList<>();
        for(PriorityQueue<Integer> pq:rows.values()){
            while(!pq.isEmpty()){
                list.add(pq.poll());
            }
        }
        ls.add(list);
       }
       return ls;
    }
}