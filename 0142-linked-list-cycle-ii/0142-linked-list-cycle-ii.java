/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head==null || head.next==null){
            return null;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast ){
               ListNode pointer1=head;
               ListNode pointer2=slow;

               while(pointer1!=pointer2){
                pointer1=pointer1.next;
                pointer2=pointer2.next;
               } 
               return pointer1;
            }
        }
        return null;
        
    }
}