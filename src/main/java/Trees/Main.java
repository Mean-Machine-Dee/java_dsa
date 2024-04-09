package Trees;

public class Main {
    public static void main(String[] args) {

//        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        binarySearchTree.insert(47);
//        binarySearchTree.insert(21);
//        binarySearchTree.insert(76);
//        binarySearchTree.insert(18);
//        binarySearchTree.insert(27);
//        binarySearchTree.insert(52);
//        binarySearchTree.insert(82);
//
////        System.out.println(binarySearchTree.BFS());
//
//        System.out.println(binarySearchTree);


        BST bst = new BST();
        bst.insertNode(47);
        bst.insertNode(21);
        bst.insertNode(76);
        bst.insertNode(18);
        bst.insertNode(27);
        bst.insertNode(52);
        bst.insertNode(82);

        System.out.println("InOrder: " );
        bst.inOrder();
        System.out.println("Contains: " + bst.rContains(27));
        System.out.println("Min Val:  " + bst.minValue());
        System.out.println("Preorder: " );
        bst.dfsPreOrder();



    }
}
