package myQueues;

import java.util.Arrays;
import java.util.Queue;

public class ArrayQueue{
    private int[] arrayQueue;
    private int size;
    private int front;
    private int back;
    private int count;

    public ArrayQueue(int capacity){
        size = capacity;
        arrayQueue = new int[size];
        front = 0;
        back = 0;
        count = 0;
    }

    public void enqueue(int item){
        if (isFull()){
            throw new StackOverflowError("It's full");
        }
        arrayQueue[back] = item;
        back = (back + 1) % size;
        count++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("it's empty");
        }
        var item = arrayQueue[front];
        arrayQueue[front] = 0;
        front = (front + 1) % size;
        count--;
        return item;
    }

    public boolean isEmpty(){
        return front == back;
    }

    public boolean isFull(){
        return count == size;
    }

    @Override
    public String toString(){
        return Arrays.toString(arrayQueue);
    }
}
