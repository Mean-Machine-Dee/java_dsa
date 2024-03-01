package LinkedLists.doublylinked;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList(5);
        dl.append(4);
        dl.append(2);
        dl.append(4);
        dl.append(5);
//        dl.append(9);
        dl.printList();
//        System.out.println("Removed " +      dl.removeFirst().data);
        System.out.println("=====AFTER ==== ");
//        dl.reverse();

        System.out.println(dl.isPalidrome());

//        dl.insert(2,45);
//        System.out.println( "Removed at 3 " + dl.remove(3).data);
        dl.printList();
    }
}
