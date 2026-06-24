/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int findMaxFork(Node root, int k) {
       int max=-1;
       while(root!=null){
           if(k < root.data){
               root=root.left;
           }
           else{
               max=Math.max(max,root.data);
               root=root.right;
           }
       }
       return max;
    }
    
    
}