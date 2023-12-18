import java.util.*;

public class LinkedListImplementation {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("in");
        list.addLast("Linked");
        list.addLast("List");
        list.addFirst("Implementation");
        list.add(2, "the");
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.size());
        list.remove(2);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}
