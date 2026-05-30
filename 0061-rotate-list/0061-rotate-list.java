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
    public ListNode findk(ListNode head, int k){
        int cnt=1;
        ListNode temp=head;
        while(temp!=null){
            if(cnt==k) return temp;
            cnt++;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
      ListNode temp=head;
      int len=1;
      while(temp.next!=null){
        len++;
        temp=temp.next;
      }
      if(k%len==0) return head;
      k=k%len;
      ListNode tail=temp;
      tail.next=head;
      ListNode newtail=findk(head,len-k);
      head=newtail.next;
      newtail.next=null;
      return head;
    }
}