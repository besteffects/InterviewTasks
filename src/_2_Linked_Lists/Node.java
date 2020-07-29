package _2_Linked_Lists;

class Node {
    //Implemented a simple linked list
    // We access a linked list through a reference to the head Node of the linked list
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
