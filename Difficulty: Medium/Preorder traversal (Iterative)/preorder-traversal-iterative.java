/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> preOrder(Node root) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        if(root==null) return ls;
        Stack<Node> st=new Stack<Node>();
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            ls.add(root.data);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
                
        }
        return ls;
    }
}