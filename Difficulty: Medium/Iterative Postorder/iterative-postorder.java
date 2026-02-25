// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tree {
    ArrayList<Integer> postOrder(Node node) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        Stack<Node> st=new Stack<Node>();
        Node curr=node;
        Node prev=null;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            Node temp=st.peek();
            if(temp.right!=null && temp.right!=prev){
                curr=temp.right;
            }
            else{
                ls.add(temp.data);
                prev=st.pop();
            }
        }
        return ls;
    }
}