package LinkedLists;

public class LinkedList {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println("Item is : " + temp.data);
            temp = temp.next;
        }


    }


    public void appendNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        size ++;
    }

    public Node removeLast(){
        //check if its empy
        if(size == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        size --;

        //checking if no items remains
        if(size == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    // append a node at the head

    public void prepend(int data){
        Node node = new Node(data);
        if(size == 0){
            head = node;
            tail = node;
        }else{
            //new head points to old head
            node.next = head;
            //swap old head to the new head ie node
            head = node;
        }
        size ++;
    }


    public void removeFirst(){
        if(size != 0){
            Node temp = head;
            head = head.next;
            System.out.println("Removed: " + temp.data);
        }else{
            System.out.println("Null");
        }
    }


}
