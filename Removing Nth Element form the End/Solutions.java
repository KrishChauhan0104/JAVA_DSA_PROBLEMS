import java.util.*;
public class Solutions {
    int val;
    Solutions next;

    public Solutions(int val) {
        this.val = val;
        this.next = null;
    }


    public static Solutions removeNthFromEnd(Solutions head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        // Use two pointers to maintain a window of size n+1
        Solutions fast = head;
        Solutions slow = head;
        Solutions prev = null;

        // Move the fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                // If n is greater than the length of the linked list, do nothing
                return head;
            }
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // If the element to be removed is the first one
        if (prev == null) {
            return head.next;
        }

        // Remove the nth element from the end
        prev.next = slow.next;

        return head;
    }

    public static void printList(Solutions head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solutions head = new Solutions(1);
        head.next = new Solutions(2);
        head.next.next = new Solutions(3);
        head.next.next.next = new Solutions(4);
        head.next.next.next.next = new Solutions(5);

        System.out.println("Original Linked List:");
        printList(head);

        int n = 3; // Specify the value of n

        Solutions result = removeNthFromEnd(head, n);

        System.out.println("Linked List after removing the " + n + "th element from the end:");
        printList(result);
    }
}
