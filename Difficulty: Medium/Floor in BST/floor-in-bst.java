/*
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/
class Solution {
    public int findFloor(Node root, int x) {
        // code here
        int max=-1;
        while(root!=null){
            if(x < root.data){
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
