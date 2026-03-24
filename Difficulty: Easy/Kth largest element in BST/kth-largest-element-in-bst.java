/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    int ans=0;
    int cnt=0;
    public int kthLargest(Node root, int k) {
        // Your code here
        revinorder(root,k);
        return ans;
        
    }
    private void revinorder(Node root,int k){
        if(root==null) return ;
        revinorder(root.right,k);
        cnt++;
        if(cnt==k){
            ans=root.data;
            return;
        }
        revinorder(root.left,k);
        
    }
}