package myTrees;

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
}
