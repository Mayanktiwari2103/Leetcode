/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {

        ArrayList<Node> ans = new ArrayList<>();
        List<Node> list = new ArrayList<>();

        inorder(root, list);

        Node pre = null;
        Node suc = null;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).data < key) {
                pre = list.get(i);
            }
            else if (list.get(i).data > key) {
                suc = list.get(i);
                break;
            }
        }

        ans.add(pre);
        ans.add(suc);

        return ans;
    }

    private void inorder(Node root, List<Node> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}