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
    public ListNode find(ListNode head,int k){
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
       int cnt=1;
       while(temp.next!=null){
        temp=temp.next;
        cnt++;
       }
       ListNode tail=temp;
       int len=cnt;
       if(k%len==0) return head;
       k=k%len;
       tail.next=head;
       ListNode newtail=find(head,len-k);
       head=newtail.next;
       newtail.next=null;
       return head;

        
        

    }
}