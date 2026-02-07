class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node() {};
        Node(int key, int value ){
           this.key=key;
           this.value=value;

        }
    }

    Node head = new Node();
    Node tail = new Node();
    int cap;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        cap=capacity;
        map=new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
        public void insertafterhead(Node node) {
           node.next=head.next;
           node.prev=head;
           head.next.prev=node;
           head.next=node;
        }

        public void deletenode(Node node) {
            Node prevnode=node.prev;
            Node nextnode=node.next;
            prevnode.next=nextnode;
            nextnode.prev=prevnode;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            Node node=map.get(key);
            deletenode(node);
            insertafterhead(node);
            return node.value;

        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() == cap) {
                    Node lru =tail.prev;
                    map.remove(lru.key);
                    deletenode(lru);

                }
                Node node = new Node(key, value);
                map.put(key,node);
                insertafterhead(node);
            }
            else{
                Node node=map.get(key);
                node.value=value;
                deletenode(node);
                insertafterhead(node);

            }
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */