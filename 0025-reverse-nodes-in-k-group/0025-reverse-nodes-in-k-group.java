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
    public ListNode reverse(ListNode head,int k){
        ListNode temp=head;
        ListNode prev=null;
        int cnt=0;
        while(temp!=null && cnt<k){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
            cnt++;
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