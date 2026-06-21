/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
         ArrayList<ArrayList<Integer>> ls= new ArrayList<ArrayList<Integer>>();
         generate(root,new ArrayList<>(),ls);
         return ls;
    }
    
    private void generate(Node root,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ls){
        if(root==null) return;
        list.add(root.data);
        if(root.left==null && root.right==null){
            ls.add(new ArrayList<>(list));
            
        }
        else{
            generate(root.left,list,ls);
        generate(root.right,list,ls);
        }
        
        list.remove(list.size()-1);
    }
}