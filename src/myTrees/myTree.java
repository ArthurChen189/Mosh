package myTrees;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class myTree {
    private class Node{
        private int value;
        private Node leftChild,rightChild;
        private Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value){
        if (root == null){
            root = new Node(value);
            return;
        }
        var traverser = root;
        var item = new Node(value);
        while(true){ // TODO: 2020/4/1
            if (value > traverser.value){
                if (traverser.rightChild == null){
                    traverser.rightChild = item;
                    break;
                }
                traverser = traverser.rightChild;
            }else{
                if (traverser.leftChild == null){
                    traverser.leftChild = item;
                    break;
                }
                traverser = traverser.leftChild;
            }
        }
    }

    public boolean find(int value){
        if (root == null){
            throw new IllegalStateException();
        }
        var traverser = root;
        while (traverser != null){
            if(value > traverser.value){
                traverser = traverser.rightChild;
            }else if (value < traverser.value){
                traverser = traverser.leftChild;
            }else{
                return true;
            }
        }
        return false;
    }


    private void traversePreOrder(Node root){
        // root
        // left
        // right
        if (root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traverseInOrder(Node root){
        // left
        // root
        // right
        if (root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traversePostOrder(Node root){
        // left
        // right
        // root
        if (root == null) return;
        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }


    private int height(Node root){
        if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) return 0;
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

    public int height(){
        return height(root);
    }

    private int minVal(Node root){
        if (root.leftChild == null && root.rightChild == null) return root.value;

    var left = minVal(root.leftChild);
    var right = minVal(root.rightChild);

        return Math.min(Math.min(left,right),root.value);
}

    public int minVal(){
        return minVal(root);
    }



    public boolean equalNode(myTree other){
        if (other == null) return false;
        return equalNode(other.root,root);
    }


    private boolean equalNode(Node first, Node second){

        if(first == null && second == null) return true;

        if (first != null && second != null){
            return first.value == second.value
                    && equalNode(first.leftChild,second.leftChild)
                    && equalNode(first.rightChild,second.rightChild);
        }
        return false;
    }

    public boolean isValidBinarySearchTree(){
        if (root == null) return false;
        return isValidBinarySearchTree(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }


    private boolean isValidBinarySearchTree(Node node,int maxVal,int minVal){
        if (node == null) return true;
        if (node.value > maxVal || node.value < minVal) return false;
        return isValidBinarySearchTree(node.rightChild,node.value-1,minVal) && isValidBinarySearchTree(node.leftChild,maxVal,node.value+1);
    }

    public ArrayList<Integer> getNodesAtKDistance(int distance){
        ArrayList<Integer> arraylist = new ArrayList<>();
        getNodesAtKDistance(root,distance,arraylist);
        return arraylist;
    }

    private void getNodesAtKDistance(Node node,int distance,ArrayList<Integer> arraylist){
        if (node == null) return;
        if (distance == 0){
            arraylist.add(node.value);
            return;
        }
        getNodesAtKDistance(node.leftChild,distance-1,arraylist);
        getNodesAtKDistance(node.rightChild,distance-1,arraylist);
    }

    public void breadthFirstTraversal() {
        for (int i = 0; i < height(); i++) {
            var list = getNodesAtKDistance(i);
            for (var j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
