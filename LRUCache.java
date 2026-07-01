class LRUCache {
    private MyHashTable hashTable;
    private DoublyLinkedList dll;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashTable = new MyHashTable(capacity);
        this.dll = new DoublyLinkedList();
        this.size = 0;
    }

    // Task 9: Implement get()
    public Integer get(int key) {
        Node node = hashTable.search(key);       
        if (node == null) {
            return null; 
        }
        dll.moveToFront(node);       
        return node.value;
    }

    // Task 9: Implement put()
    public void put(int key, int value) {
        Node existingNode = hashTable.search(key);
        if (existingNode != null) {          
            existingNode.value = value;
            dll.moveToFront(existingNode);
        } else {         
            Node newNode = new Node(key, value);                       
            if (size == capacity) {               
                Node removed = dll.removeTail();              
                if (removed != null) {
                    hashTable.remove(removed.key);
                    System.out.println("Evicted LRU Key: " + removed.key);
                    size--;
                }
            }

            hashTable.insert(key, newNode);
            dll.addToFront(newNode);
            size++;
        }
    }

    // removing element 
    public void remove(int key) {
        Node node = hashTable.search(key);
        if (node == null) {
            System.out.println("Key not found!");
            return;
        }
        dll.removeNode(node);
        hashTable.remove(key);
        size--;
        System.out.println("Key: " + key + " is removed successfully.");
    }
    public void display() {
        dll.display();
    }
    public int getSize() {
        return size;
    }
}