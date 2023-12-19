import java.util.LinkedList;

public class ReverseLinkedList {

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public ReverseLinkedList() {
        this.head = null;
    }

    public Node reverseListRecursive(Node current) {
        if (current == null || current.next == null) {
            return current;
        }
        Node newHead = reverseListRecursive(current.next);
        current.next.next = current;
        current.next = null;
        return newHead;
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node("1");
        list.head.next = new Node("2");
        list.head.next.next = new Node("3");
        list.head.next.next.next = new Node("4");

        System.out.println("Original Linked List:");
        list.printList();

        list.reverseList();
        System.out.println("Reversed Linked List (Iterative):");
        list.printList();

        list.head = list.reverseListRecursive(list.head);
        System.out.println("Reversed Linked List (Recursive):");
        list.printList();
    }
}

    

