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
    public ListNode find(ListNode head, int k){
        ListNode temp=head;
        int count=1;
        while(temp!=null){
            if(count==k){
                return temp;
            }
            count++;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode tail=head;
        int count=1;
        while(tail.next!=null){
            tail=tail.next;
            count++;

        }
        if(k%count==0) return head;
        k=k%count;
        tail.next=head;
        ListNode newlastnode=find(head,count-k);
        head=newlastnode.next;
        newlastnode.next=null;
        return head;

        
    }
    
}