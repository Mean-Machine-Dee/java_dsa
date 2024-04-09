package Groking;

public class GLinkedList {

    static class ListNode{
        public int value;
        ListNode next;

        ListNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        System.out.println("Nodes before");
        printList(head);
        ListNode ans = reverse(head, 2,4);
        System.out.println();
        System.out.println("Nodes after reversal ");
        printList(ans);
    }


    public static ListNode reverse(ListNode head, int p, int q){

        if(p == q){
            return head;
        }
        //skip p-1 previous is node p-1
        ListNode current = head, previous = null;
        for(int i=0; current != null && i < p-1; ++i){
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = previous;
        ListNode  lastNodeOfSubList = current;
        ListNode next = null;

        for(int i =0; current != null && i < q - p+1; i++){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next; //5
        }

        if(lastNodeOfFirstPart != null){
            lastNodeOfFirstPart.next = previous;
        }else{
            head = previous;
        }

        lastNodeOfSubList.next = current;

        return head;
    }

    public static void printList(ListNode node){
        while (node != null){
            System.out.print(node.value + " " );
            node = node.next;
        }
    }
}
