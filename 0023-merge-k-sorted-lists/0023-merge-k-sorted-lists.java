/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode ans=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ans.next=l1;
                l1=l1.next;
            }
            else{
                ans.next=l2;
                l2=l2.next;
            }
            ans=ans.next;
        }
        if(l1!=null) ans.next=l1;
        else ans.next=l2;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return mergehelper(lists,0,lists.length-1);
    }
    public ListNode mergehelper(ListNode lists[],int left, int right){
        if(left==right) return lists[left];
        int mid=left+(right-left)/2;
        ListNode l1= mergehelper(lists,left,mid);
        ListNode l2= mergehelper(lists,mid+1,right);
        return  merge(l1,l2);
    }
}