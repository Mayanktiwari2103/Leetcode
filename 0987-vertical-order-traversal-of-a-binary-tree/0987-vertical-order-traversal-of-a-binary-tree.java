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
class Triplet {
    TreeNode node;
    int row;
    int col;

    Triplet(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<Triplet> q=new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        q.offer(new Triplet(root,0,0));
        while(!q.isEmpty()){
            Triplet p=q.poll();
            TreeNode node=p.node;
            int row=p.row;
            int col=p.col;
            map
                .computeIfAbsent(col,k->new TreeMap<>())
                .computeIfAbsent(row,k->new PriorityQueue<>())
                .offer(node.val);
            if(node.left!=null){
                q.offer(new Triplet(node.left,row+1,col-1));
            } 
            if(node.right!=null){
                q.offer(new Triplet(node.right,row+1,col+1));
            }
        }

       
for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

    List<Integer> columnList = new ArrayList<>();

    for (PriorityQueue<Integer> pq : rows.values()) {

        while (!pq.isEmpty()) {
            columnList.add(pq.poll());
        }
    }

    result.add(columnList);
}
        return result;
    }
}