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
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = curr.next;
        while (temp != null) {
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;

        }
        curr.next=prev;
        prev=curr;
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null) slow=slow.next;
        ListNode newhead = reverse(slow);
        while(newhead!=null){
            if(head.val!=newhead.val) return false;
            head=head.next;
            newhead=newhead.next;
        }
        return true;

    }
}