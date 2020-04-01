package myQueues;

import java.util.Arrays;

public class PriorityQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int count;

    public PriorityQueue(int size){
        this.queue = new int[size];
        this.count = 0;
    }

    public void insert(int item){
        if (count == queue.length){
            throw new IllegalStateException("It's full");
        }

        for (int i = count - 1; i >= 0 ; i--) {
            if (item < queue[i]){
                queue[i+1] = queue[i];
            }

            queue[i+1] = item;
            count++;
        }
    }

    public int remove(){
        if (count == 0){
            throw new IllegalStateException("It's empty");
        }
        return queue[--count];
    }



    @Override
    public String toString(){
        return Arrays.toString(queue);
    }



}
