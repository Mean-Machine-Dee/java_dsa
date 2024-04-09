package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    Node root;




    class Node {
        int data;
        Node left = null;
        Node right = null;


        public Node(int data) {
            this.data = data;
        }
    }

        public boolean insert(int data){
            Node newNode = new Node(data);
            if(root == null){
                root = newNode;
                return true;
            }

            Node temp = root;
            while(true){
                if(newNode.data == temp.data) return false;
                if(newNode.data < temp.data){
                    //insert to the left
                    if(temp.left == null){
                        temp.left = newNode;
                        return true;
                    }
                    temp = temp.left;
                }else{
                    if(temp.right == null){
                        temp.right = newNode;
                        return true;
                    }
                    temp = temp.right;
                }
            }
        }

        public boolean contains(int value){
            Node temp = root;
            while (temp != null){
                if(value < temp.data){
                    temp = temp.left;
                }else if(value > temp.data){
                    temp = temp.right;
                }else{
                    return true;
                }
            }
            return false;
        }





        public void insertR(int data){
            root = insertRecurse(root,data);
        }

        public Node insertRecurse(Node root, int data){
        if(root == null){
            root = new Node(data);
        }else if(data < root.data){
            root.left = insertRecurse(root.left, data);
        }else if(data > root.data){
            root.right = insertRecurse(root.right, data);
        }
        return root;
        }





        public List<Integer> BFS(){
            Node currentNode = root;
            Queue<Node> queue = new LinkedList<>();
            List<Integer> results = new ArrayList<>();
            queue.add(currentNode);
            while (queue.size() > 0){
                currentNode = queue.remove();
                results.add(currentNode.data);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }

            return results;
        }





    }




