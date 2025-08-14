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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        head=reverse(head);
        if(n==1){
            head=head.next;
        }
        else{
            ListNode temp=head;
            int count=1;
            while(temp!=null && count<n-1){
                temp=temp.next;
                count++;
            }
            if(temp!=null && temp.next!=null){
                temp.next=temp.next.next;
            }
        }
        
        head=reverse(head);
        return head;


        
    }
}