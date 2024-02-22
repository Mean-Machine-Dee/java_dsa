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

//        LinkedList.Node getIndex = linkedList.get(4);
//        System.out.println("At index: "+  (getIndex != null ? getIndex.data: "null"));

        linkedList.set(3,46);

        linkedList.printList();
//        System.out.println("Removed : " + linkedList.removeLast().data);
//        linkedList.removeFirst();
//        linkedList.printList();

    }
}
