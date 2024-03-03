package linkedlist;

public class SinglyLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void print() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.getValue() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    @Override
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }

        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    @Override
    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.setNext(this.head);
        this.head = newNode;
        this.length++;
    }

    @Override
    public boolean insert(int index, int value) {
        return false;
    }
}
