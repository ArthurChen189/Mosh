package myQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10);
        queue.insert(10);
        queue.insert(30);
        queue.insert(40);
        queue.insert(10);

        System.out.println(queue.toString());
    }
}
