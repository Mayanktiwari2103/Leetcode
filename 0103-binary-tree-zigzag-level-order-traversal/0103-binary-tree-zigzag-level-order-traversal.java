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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls=new ArrayList<>();
        Deque<TreeNode> dq=new LinkedList<>();
        if(root==null) return ls;
        dq.addLast(root);
        int level=0;
        while(!dq.isEmpty()){
            int size=dq.size();
            ArrayList<Integer> list=new ArrayList<>();
            level++;
            for(int i=0;i<size;i++){
                if(level % 2==1){
                    TreeNode curr=dq.removeLast();
                    if(curr.left!=null) dq.addFirst(curr.left);
                    if(curr.right!=null) dq.addFirst(curr.right);
                    list.add(curr.val);
                }
                else{
                    TreeNode curr=dq.removeFirst();
                    if(curr.right!=null) dq.addLast(curr.right);
                    if(curr.left!=null) dq.addLast(curr.left);
                    list.add(curr.val);
                }
            }
            ls.add(list);
        }

        return ls;
    }
}   