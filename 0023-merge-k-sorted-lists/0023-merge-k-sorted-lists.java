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
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode res=dummy;
        while(list1!=null&& list2!=null){
            if(list1.val<list2.val){
                res.next=list1;
                list1=list1.next;
            }
            else{
                res.next=list2;
                list2=list2.next;
            }
            res=res.next;
        }
        if(list1!=null) res.next=list1;
        else res.next=list2;
        return dummy.next;

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return mergehelper(lists, 0, lists.length - 1);
    }
    private ListNode mergehelper(ListNode lists[],int left,int right){
         if (left == right) return lists[left];
        int mid=left+(right-left)/2;
        ListNode l1=mergehelper(lists,left,mid);
        ListNode l2=mergehelper(lists,mid+1,right);

        return merge(l1,l2);
    }
}