/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private void Insert(Node head){
        Node temp=head;
        while(temp!=null){
            Node copynode=new Node(temp.val);
            copynode.next=temp.next;
            temp.next=copynode;
            temp=temp.next.next;
        }
    }
    private void connectrandom(Node head){
        Node temp=head;
        while(temp!=null){
            Node copynode=temp.next;
            if(temp.random!=null){
              copynode.random=temp.random.next;
            }  
            temp=temp.next.next;
        }

    }
    private Node connectnext(Node head){
        Node temp=head;
        Node dummy=new Node(0);
        Node res=dummy;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;

        }
        return dummy.next;

    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Insert(head);
        connectrandom(head);
        return connectnext(head);
       
    }
}