class LRUCache {

// Basic idea is to maintain a hashmap of nodes and a doubly linked list to track the usage
// we use a doubly linked list to make sure that the HEAD is the least recently used element and the tail is the most recently used one
// inner class
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    // this is to know front and rear of linked list. we add at the end of linked list and delete it from front.
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        // if hashmap doesnt have the key
        if( !map.containsKey(key)) {
            return -1;
        }

        // remove current node and move it to tail
        Node current = map.get(key);
        //remove node from current position
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return current.value;
    }

    public void put(int key, int value) {
        // if already present then set it and return
        // get here would make sure its moved to tail
        if( get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        // if the capacity is reached
        // we remove the node after next
        // note HEAD is a sentinel node here and we do not use it and hence we remove the next one from hashmap
        // after which we set the appropriate pointers 
        // first element is the one after head
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        move_to_tail(node);
    }

    private void move_to_tail(Node current) {
        // again tail here is a sentinel and we do not store anything in it.
        // last element is the one before the tail
        current.prev = tail.prev;
        current.prev.next = current;
        tail.prev = current;        
        current.next = tail;
    }
}
