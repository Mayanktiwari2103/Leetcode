/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        if(root==null) return ls;
        left(root,ls,0);
        return ls;
    }
    private void left(Node root,ArrayList<Integer> ls,int level){
        if(root==null) return ;
        if(level==ls.size()){
            ls.add(root.data);
            
        }
        left(root.left,ls,level+1);
        left(root.right,ls,level+1);
    }
}