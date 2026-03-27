/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ls1=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();
        inorder(root1,ls1);
        inorder(root2,ls2);
        int n=ls1.size();
        int m=ls2.size();
        int l=0;
        int r=0;
        ArrayList<Integer> temp=new ArrayList<>(n+m);
        while(l<n && r<m){
            if(ls1.get(l)<=ls2.get(r)){
                temp.add(ls1.get(l));
                l++;
            }
            else{
                temp.add(ls2.get(r));
                r++;
            }
        }
        while(l<n){
            temp.add(ls1.get(l++));
        }
        while(r<m){
            temp.add(ls2.get(r++));
        }
        return temp;
        
        
    }
    private void inorder(TreeNode root,List<Integer> ls ){
        if(root==null ) return ;
        inorder(root.left,ls);
        ls.add(root.val);
        inorder(root.right,ls);
    }
    
}