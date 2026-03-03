// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    boolean areMirror(Node a, Node b) {
        // Your code here
        return check(a,b);
        
    }
    private boolean check(Node n1, Node n2){
        if(n1==null && n2==null) return true;
        if(n1==null || n2==null) return false;
        if(n1.data!=n2.data) return false;
        return check(n1.left,n2.right) && check(n2.left,n1.right);
    }
}