/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
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
        if(root==null) return ls;
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node node=p.node;
            int col=p.col;
            map.put(col,node.data);
            if(node.left!=null){
                q.add(new Pair(node.left,col-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,col+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ls.add(entry.getValue());
        }
        return ls;
    }
}