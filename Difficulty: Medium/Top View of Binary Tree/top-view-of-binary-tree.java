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
class Pair{
    Node node;
    int col;
    Pair(Node node, int col){
        this.node=node;
        this.col=col;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        if(root==null) return ls;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            Node temp=p.node;
            int col=p.col;
            if(!map.containsKey(col)) map.put(col,temp.data);
            if(temp.left!=null){
                q.add(new Pair(temp.left,col-1));
            }
            if(temp.right!=null){
                q.add(new Pair(temp.right,col+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ls.add(entry.getValue());
        }
        return ls;
        
    }
    
}