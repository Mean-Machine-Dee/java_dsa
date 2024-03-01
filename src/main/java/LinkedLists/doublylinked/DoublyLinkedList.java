package LinkedLists.doublylinked;

import LinkedLists.LinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private int size;

    static class Node{
        public int data;
        private Node next;
        private Node prev;

        public Node(int data){
            this.data = data;
        }
    }


    public DoublyLinkedList(int data){
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        size ++;
    }


    public void append(int value){
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public Node removeLast(){
        if(size == 0) return null;
        Node temp = tail;
        if(size == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        size --;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(size==0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public Node removeFirst(){
        if(size == 0) return null;
        Node temp = head;
        if(size ==1){
            head = null;
            tail = null;
        }else{
            head = temp.next;
            temp.next = null;
            head.prev = null;
        }
        size --;
        return temp;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data +"->");
            temp = temp.next;
        }
    }

    public Node get(int index){
        if( index < 0 || index >= size) return  null;
        Node temp = head;
        if(index < size /2 ){
            for (int i= 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for (int i = size-1; i > index; i--){
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int data){
        Node node = get(index);
        if(node != null){
            node.data = data;
            return true;
        }
        return false;
    }

    public boolean insert( int index, int data){
        if(index < 0 || index > size) return false;
        if(index == 0){
            prepend(data);
            return true;
        }
        if(index == size){
            prepend(data);
            return true;
        }
        //2->3->4->5->6->7
        Node newNode = new Node(data);
        Node current = get(index);
        Node before = current.prev;
        Node after = current.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        size++;
        return true;

    }

    public Node remove( int index){
        if(index < 0 || index > size) return null;
        if(index == 0){
            return removeFirst();
        }
        if(index == size){
            return removeLast();
        }
        //2->3->4->5->6->7

        Node temp = get(index);
        Node prev = temp.prev;
        Node after = temp.next;
        if(size == 1){
            head = null;
            tail = null;
        }
        prev.next = after;
        after.prev = prev;
        temp.prev = null;
        temp.next = null;
        size --;
        return temp;
    }

    public void reverse(){

        Node temp = null;
        Node current = head;
        while (current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;

//        if(temp != null){
//            head = temp.prev;
//        }
    }

    public boolean isPalidrome(){
        if(size == 0) return true;

        while(head != tail && tail != head.prev){

            if(head.data != tail.data){
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    public void swapPairs(){
        if(size == 0) return;

        Node pointerA = head;
        Node pointerB = null;
        Node temp = null;

        while(head != null){

            //swap
            temp = pointerB;
            pointerB.next = pointerA;
            pointerB.prev = pointerA.prev;
            pointerA.next = temp.next;
            pointerA.prev = temp;


            //move to the next two pointers

            head = head.next;
        }
    }


}
