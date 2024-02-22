package LinkedLists;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.appendNode(3);
        linkedList.appendNode(8);
        linkedList.appendNode(5);
        linkedList.appendNode(10);
        linkedList.appendNode(2);
        linkedList.appendNode(1);

//        LinkedList.Node getIndex = linkedList.get(4);
//        System.out.println("At index: "+  (getIndex != null ? getIndex.data: "null"));

//        linkedList.set(3,46);

//        linkedList.insert(3,46);


//        System.out.println("Removed : " + linkedList.removeLast().data);
//        linkedList.removeFirst();
//        linkedList.printList();


//        linkedList.printList();
//        System.out.println("Reversed");
//        System.out.println("Midlle: " + linkedList.middleNode().data);

//        System.out.println("kthElement: " + linkedList.findKthFromEnd(3).data);
//        linkedList.reverse();
//        linkedList.printList();

        linkedList.partitionList(5);


    }
}
