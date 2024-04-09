package Trees;

public class BST {
    Node root;
    class Node{
        int data;
        Node left;
        Node right;


        public Node(int data){
            this.data = data;
        }
    }

    public void insertNode(int data){
        root = recurseInsertNode(root,data);
    }

    private Node recurseInsertNode(Node root,int data) {
        if(root == null)
            root = new Node(data);
        else if (data < root.data)
            root.left = recurseInsertNode(root.left, data);
        else if (data > root.data)
            root.right = recurseInsertNode(root.right, data);
        return root;
    }


    public void inOrder(){
        inOderRecurse(root);
    }

    public void inOderRecurse(Node root){
        if(root != null){
            inOderRecurse(root.left);
            System.out.print(root.data + " ");
            inOderRecurse(root.right);
        }

    }
    private boolean rContains(Node currentNode, int data){
        if(currentNode == null) return false;
        if(currentNode.data == data) return true;
        if(data < currentNode.data){
            return rContains(currentNode.left, data);
        }else{
            return rContains(currentNode.right, data);
        }
    }

    public boolean rContains(int data){
        return rContains(root, data);
    }

    public int minValue(){
        int minLeft = minValueHelper(root.left);
        int minRight = minValueHelper(root.right);

        System.out.println("Left " + minLeft + " " + minRight);
        return Math.min(minLeft, minRight);
    }

    public int minValueHelper(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }


    public void dfsPreOrder(){
        dfsPreOrderRecurse(root);
    }

    private void dfsPreOrderRecurse(Node currentNode) {

        if(currentNode != null){
            System.out.print(currentNode.data + " ");
            dfsPreOrderRecurse(currentNode.left);
            dfsPreOrderRecurse(currentNode.right);
        }
    }
    public void dfsPostOrder(){
        dfsPreOrderRecurse(root);
    }



    private void  dfsPostOrderRecurse(Node currentNode) {
        if(currentNode != null){
            dfsPreOrderRecurse(currentNode.left);
            dfsPreOrderRecurse(currentNode.right);
            System.out.print(currentNode.data + " ");
        }
    }


}
