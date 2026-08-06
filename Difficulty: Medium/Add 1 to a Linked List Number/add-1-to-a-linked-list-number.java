/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    private Node reverse(Node head){
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        Node newhead=reverse(head);
        Node temp=newhead;
        Node dummy=new Node(0);
        Node curr=dummy;
        int carry=1;
        while(temp!=null){
            int sum=carry;
            sum+=temp.data;
            carry=sum/10;
            sum=sum%10;
            curr.next=new Node(sum);
            curr=curr.next;
            temp=temp.next;
        }
        
        if(carry>0){
            curr.next=new Node(carry);
        }
        return reverse(dummy.next);
        
    }
}