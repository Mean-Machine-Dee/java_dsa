package Groking;

import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}
public class BTreeGroking {

    public static  List<List<Integer>> bfsTravesal(TreeNode root){

//        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if(root == null) return results;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // push the first item in bst

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i=0; i < levelSize; i++){
                //remove parent
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                //insert the children of current to queue
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            results.add(0,currentLevel);

        }
        return results;
    }
    
    public static List<List<Integer>> zigZagTraversal(TreeNode root){
        List<List<Integer>> results = new ArrayList<>();

        if(root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new LinkedList<>();
            System.out.println("que size " + levelSize + " " + queue.peek().val + "current level " );
                for (int i=0; i < levelSize; i++){
                    TreeNode currentNode = queue.poll();
                    if(leftToRight){
                        currentLevel.add(currentNode.val);
                    }else{
                        currentLevel.add(0, currentNode.val);
                    }
                    //insert the children of current to queue
                    if(currentNode.left != null){
                        queue.offer(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.offer(currentNode.right);
                    }
                }


            results.add(currentLevel);
            leftToRight = ! leftToRight;
        }

        return results;
    }


    public static List<Double> findAvarages(TreeNode root){
        List<Double> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
         int levelSize = queue.size();
         double levelSum = 0;
         for (int i=0; i < levelSize; i++){
             TreeNode currentNode = queue.poll();
             levelSum += currentNode.val;

             if(currentNode.left != null){
                 queue.offer(currentNode.left);
             }
             if(currentNode.right != null){
                 queue.offer(currentNode.right);
             }
         }

         results.add(levelSum/levelSize);
        }

        return  results;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

//        List<List<Integer>> result = bfsTravesal(root);
//        List<List<Integer>> results = zigZagTraversal(root);
//        System.out.println("BFS traversal " + result);
//        System.out.println("ZIGZAG traversal " + results);
//
        List<Double> results = findAvarages(root);
        System.out.println("Avarages are  " + results);
//        System.out.println("ZIGZAG traversal " + results);
    }
    
    
    
}
