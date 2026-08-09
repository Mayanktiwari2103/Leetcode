/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        return check(root);
        
    }
    
    private boolean check(Node root){
        if(root==null) return true ;
        if(root.left!=null && root.right!=null){
            if(root.left.data+root.right.data != root.data){
                return false;
            }
        }
        if(root.left!=null && root.right==null) {
            if(root.left.data !=root.data) return false;
        }
        if(root.right!=null && root.left==null){
            if(root.right.data!=root.data) return false;
        }
        return check(root.left) && check(root.right);
    }
}