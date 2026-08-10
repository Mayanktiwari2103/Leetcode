/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
class Pair{
    Node node;
    int col;
    Pair(Node node, int col){
        this.node=node;
        this.col=col;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
       ArrayList<Integer> ls=new ArrayList<>();
       TreeMap<Integer,Integer> map=new TreeMap<>();
       Queue<Pair> q=new LinkedList<>();
       
       q.add(new Pair(root,0));
       while(!q.isEmpty()){
           Pair curr=q.poll();
           Node node=curr.node;
           int col=curr.col;
           map.put(col,node.data);
           if(node.left!=null){
               q.add(new Pair(node.left,col-1));
           }
           
           if(node.right!=null){
               q.add(new Pair(node.right,col+1));
           }
       }
       
       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           ls.add(entry.getValue());
       }
       return ls;
    }
}