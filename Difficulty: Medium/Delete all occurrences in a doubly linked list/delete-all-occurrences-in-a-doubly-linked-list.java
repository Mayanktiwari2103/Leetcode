/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node temp=head;
        while(temp!=null){
            Node back=temp.prev;
            Node front=temp.next;
            if(temp.data!=x){
                temp=front;
            }
            else if(back==null && temp.data==x){
                head=front;
                front.prev=back;
            }
            else{
                if(front!=null)front.prev=back;
                back.next=front;
            }
            temp=front;
            
        }
        return head;
    }
}