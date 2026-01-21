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
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
                temp=temp.next;
            }
        }
        while(l1!=null){
            temp.next=l1;
            l1=l1.next;
            temp=temp.next;
        }
        while(l2!=null){
            temp.next=l2;
            l2=l2.next;
            temp=temp.next;
        }
        return dummy.next;


    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null  && fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;

        }
        ListNode rightstart=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(rightstart);
        return merge(left,right);

    }
}