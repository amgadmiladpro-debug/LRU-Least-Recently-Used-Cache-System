// ================= NODE =================
class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node nextInBucket;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// ================= DOUBLY LINKED LIST =================
public class DoublyLinkedList {
    Node head;
    Node tail;

    // first insert
    public void addToFront(Node node) {
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    // delete node
    public void removeNode(Node node) {
        if (node == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = node.prev = null;
    }

    // move to front
    public void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    // (LRU)
    public Node removeTail() {
        if (tail == null) return null;
        Node temp = tail;
        removeNode(tail);
        return temp;
    }

    //  display
    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print("(" + curr.key + "," + curr.value + ") -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }
}