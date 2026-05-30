/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node headRef) {
        // code here
       Node temp=headRef;
       while(temp.next!=null){
           Node back=temp.prev;
           Node front=temp.next;
           if(temp.data!=front.data){
               temp=front;
           }
           else if(back==null){
               headRef=front;
               front.prev=back;
           }
           else{
               front.prev=back;
               back.next=front;
           }
           temp=front;
       }
       
       return headRef;
    }
}