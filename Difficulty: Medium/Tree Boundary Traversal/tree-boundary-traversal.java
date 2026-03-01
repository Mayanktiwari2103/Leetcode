/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        if(root==null) return ls;
        if(!isLeaf(root)){
            ls.add(root.data);
        }
        left(root.left,ls);
        leaf(root,ls);
        right(root.right,ls);
        return ls;
    }
    static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    void left(Node root, ArrayList<Integer> ls){
        if(root==null || isLeaf(root) ) return ;
        ls.add(root.data);
        if(root.left!=null){
            left(root.left,ls);
        }
        else if(root.right!=null){
            left(root.right,ls);
        }
    }
    void leaf(Node root, ArrayList<Integer> ls){
        if(root==null) return ;
        if(isLeaf(root)){
            ls.add(root.data);
        }
        leaf(root.left,ls);
        leaf(root.right,ls);
    }
    void right(Node root, ArrayList<Integer> ls){
        if(root==null || isLeaf(root)) return ;
        if(root.right!=null){
            right(root.right,ls);
            
        }
        else if(root.left!=null){
            right(root.left,ls);
        }
        ls.add(root.data);
    }
}