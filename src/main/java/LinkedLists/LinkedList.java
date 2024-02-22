package LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    class Node {
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


    public Node removeFirst(){
        if(size == 0)   return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        size --;
        return temp;
    }


    public Node get(int index){
        if(index < 0 || index == size) return null;
        Node temp = head;
        for (int i=0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int data){
        Node temp = get(index);
        if(temp != null){
            temp.data = data;
            return true;
        }
        return false;

    }

    public boolean insert(int index, int data){
        if(index < 0 || index > size) return false;
        if(index == 0){
            prepend(data);
            size++;
            return true;
        }else if(index == size){
            appendNode(data);
            size++;
            return true;
        }else{

            //previous node to current index
            Node newNode = new Node(data);
            Node temp = get(index -1);
            newNode.next = temp.next;
            temp.next = newNode;
            return true;
        }



    }

    public Node remove(int index){
        if( index < 0 || index >= size) return null;
        if(index == 0) return removeFirst();
        if(index == size - 1) return removeLast();
        Node prev = get(index -1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        size --;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after;
        Node before = null;

        for (int i = 0; i < size; i++){
            after = temp.next;
            temp.next =  before;
            before =temp;
            temp = after;
        }


    }


    public Node middleNode(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            System.out.println("Slow is: " + slow.data + " Fast: is "+ fast.data );
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("Slow is: " + slow.data + " Fast: is "+ fast.data );

        }
        return slow;
    }


    public boolean hasCycle(){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public Node findKthFromEnd(int index){
       if(head == null || head.next == null) return null;
       Node slow = head;
       Node fast = head;

       for (int i= 0; i < index; i++){
           if(fast == null){
               return null;
           }
           fast = fast.next;
       }
        while(fast != null){
           slow = slow.next;
           fast = fast.next;
       }
       return slow;
    }


    public void partitionList(int x){
            if (head == null) return;
            Node dummy1 = new Node(0);
            Node dummy2 = new Node(0);
            Node prev1 = dummy1;
            Node prev2 = dummy2;
            Node current = head;

            while (current != null) {
                if (current.data < x) {
                    prev1.next = current;
                    prev1 = current;
                } else {
                    prev2.next = current;
                    prev2 = current;
                }
                current = current.next;
            }

            prev2.next = null;
            prev1.next = dummy2.next;

            head = dummy1.next;
        }



















}
