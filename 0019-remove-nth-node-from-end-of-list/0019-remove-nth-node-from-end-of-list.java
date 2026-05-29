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
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        if(len==n){
            return head.next;
        }
        temp=head;
        int cnt=1;
        while(temp!=null){
            if(cnt==len-n){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
            cnt++;

        }

        return head;
    }
}