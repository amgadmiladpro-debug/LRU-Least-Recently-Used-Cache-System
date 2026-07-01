public class MyHashTable {
    private Node[] buckets;
    private int capacity;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    // Task 7: Hash Function
    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    // Task 8: Insert
    public void insert(int key, Node node) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = node;
        } else {
            node.nextInBucket = buckets[index];
            buckets[index] = node;
        }
    }

    // Task 8: Search
    public Node search(int key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) return current;
            current = current.nextInBucket;
        }
        return null;
    }

    // Task 8: Remove
    public void remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) buckets[index] = current.nextInBucket;
                else prev.nextInBucket = current.nextInBucket;
                return;
            }
            prev = current;
            current = current.nextInBucket;
        }
    }
}