package LinkedLists;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.appendNode(4);
        linkedList.appendNode(41);
        linkedList.appendNode(43);
        linkedList.appendNode(44);
        linkedList.appendNode(54);

        linkedList.printList();
        System.out.println("Removed : " + linkedList.removeLast().data);
        linkedList.printList();

    }
}
