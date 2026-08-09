/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*class Tuple{
    int node;
    int parent;
    Tuple(int node, int parent){
        this.node=node;
        this.parent=parent;
    }
}*/
class Solution {
    private void parentmark(HashMap<TreeNode, TreeNode> map, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                    map.put(curr.left, curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    map.put(curr.right, curr);
                }

            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return ls;
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        parentmark(map, root);
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k) {
                while (!q.isEmpty()) {
                    ls.add(q.poll().val);
                }
                break;
            }
            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && (!visited.contains(curr.right))) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                TreeNode parent = map.get(curr);
                if (parent != null && (!visited.contains(parent))) {
                    q.add(parent);
                    visited.add(parent);
                }
            }
            level++;
        }

        return ls;

    }
}