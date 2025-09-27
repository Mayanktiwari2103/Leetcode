class LRUCache {
    class ListNode {
        int key, val;
        ListNode prev, next;
        ListNode() {}
        ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    HashMap<Integer, ListNode> map = new HashMap<>();
    int cap;
    ListNode head = new ListNode();
    ListNode tail = new ListNode();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void deletenode(ListNode node) {
        ListNode prevnode = node.prev;
        ListNode nextnode = node.next;
        prevnode.next = nextnode;
        nextnode.prev = prevnode;
    }

    private void insertafterhead(ListNode node) {
        ListNode currafterhead = head.next;
        head.next = node;
        node.next = currafterhead;
        node.prev = head;
        currafterhead.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        deletenode(node);
        insertafterhead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == cap) {
                ListNode lru = tail.prev;
                map.remove(lru.key);
                deletenode(lru);
            }
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            insertafterhead(node);
        } else {
            ListNode node = map.get(key);
            node.val = value;
            deletenode(node);
            insertafterhead(node);
        }
    }
}
