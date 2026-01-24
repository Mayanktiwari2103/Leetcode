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
    public ListNode reverse(ListNode head, int k){
        ListNode curr=head;
        ListNode prev=null;
        while(k>0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            k--;
        }
        return prev;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int cnt=0;
        while(cnt<k && temp!=null){
            temp=temp.next;
            cnt++;
        }
        if(cnt==k){
            ListNode newhead=reverse(head,k);
            head.next=reverseKGroup(temp,k);
            return newhead;
        }
        else{
            return head;
        }
    }
}