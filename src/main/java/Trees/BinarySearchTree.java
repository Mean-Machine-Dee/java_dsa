package Trees;

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

    }




