class Node { // user defined data type
    int val;
    Node next; // null

    Node(int val) {
        this.val = val;
    }
}

class LinkedList {
    // user defined data structure
    Node head; // null
    Node tail; // null
    int size;

    int search(int val) {
        if (head == null) {
            return -1;
        }
        Node temp = head; // temp node for traversing the linked list
        int idx = 0;
        while (temp != null) {
            if (temp.val == val) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;

    }

    void addAtHead(int val) {
        Node temp = new Node(val);
        if (head == null)
            head = tail = temp;
        else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void deleteAtHead() {
        if (head == null) {
            System.out.println("List Is Empty");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    void addAtTail(int val) {
        Node temp = new Node(val);
        if (tail == null)
            head = tail = temp;
        else {
            tail.next = temp;
            tail = temp;
        }
    }

    void display() {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insert(int val, int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid Index");
            return;
        }
        if (idx == 0)
            addAtHead(val);
        else if (idx == size)
            addAtTail(val);
        else {
            Node temp = head;
            for (int i = 1; i <= idx - 1; i++) {
                temp = temp.next;
            }
            Node t = new Node(val);
            t.next = temp.next;
            temp.next = t;
            size++;
        }
    }

    public void delete(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("invalid index");
            return;
        }
        if (idx == 0) {
            deleteAtHead();
            return;
        }
        Node temp = head;
        for (int i = 1; i <= idx - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next; // delete
        if (idx == size - 1)
            tail = temp; // we are deleting tail
        size--;

    }
}

public class LinkedListDataStructure {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.deleteAtHead();
        ll.addAtTail(10);
        ll.addAtTail(20);
        ll.addAtTail(30);
        ll.addAtTail(40);
        ll.display();
        ll.addAtHead(50);
        ll.addAtHead(60);
        ll.deleteAtHead();
        ll.display();
        System.out.println(ll.size);
        ll.insert(40, 2);
        ll.display();
        ll.delete(3);
        ll.display();
    }
}
