package myTrees;

public class Main {
    public static void main(String[] args) {
        myTree tree = new myTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.find(2));
        tree.traverseInOrder();
        System.out.println("-------------------");
        System.out.println(tree.height());
    }
}
