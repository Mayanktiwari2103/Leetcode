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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        ListNode ans=head;
        ListNode prev=null;
        int pos=1;
        while(pos!=cnt-n+1){
            prev=ans;
            ans=ans.next;
            pos++;

        }
        if(prev==null) return head.next;
         prev.next=ans.next;
        return head;
    }
}