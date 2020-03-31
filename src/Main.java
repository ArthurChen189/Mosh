import ArrayClass.Array;
import ArrayClass.myLinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println(list.size());
        list.reverse();
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.findLastKthNode(-1));
    }
}
