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
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        Map<Integer,Integer> map=new TreeMap<>();
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node curr=p.node;
            int col=p.col;
            map.put(col,curr.data);
            if(curr.left!=null){
                q.add(new Pair(curr.left,col-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right,col+1));
            }
            
        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ls.add(entry.getValue());
        }
        return ls;
    }
}