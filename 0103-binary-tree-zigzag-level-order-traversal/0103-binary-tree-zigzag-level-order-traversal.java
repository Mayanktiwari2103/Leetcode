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
        List<List<Integer>> ls = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null)
            return ls;
        q.addLast(root);
        int level = 0;
        while (!q.isEmpty()) {
            int cap = q.size();
            List<Integer> sublist = new LinkedList<Integer>();
            level++;
                for (int i = 0; i < cap; i++) {
                    TreeNode curr = q.removeFirst();
                    if (curr.left != null)
                        q.addLast(curr.left);
                    if (curr.right != null)
                        q.addLast(curr.right);
                    sublist.add(curr.val);
                }
                if(level%2==0){
                    Collections.reverse(sublist);
                } 
                ls.add(sublist);          
        }
        return ls;
    }
}   