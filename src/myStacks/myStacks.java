package myStacks;

import java.util.Arrays;

public class myStacks {
    private int[] stack;
    private int counter;
    private final int size = 100;

    public myStacks(){
        stack = new int[size];
        counter = 0;
    }

    public int getSize(){
        return size;
    }

    public void push(int item){
        if (counter >= size){
            throw new StackOverflowError("Out of Bound");
        }
        stack[counter++] = item;
    }

    public int pop(){
        if (counter == 0){
            throw new IllegalStateException("Empty stack");
        }
        return stack[--counter];
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack,0,counter);
        return Arrays.toString(content);
    }

}
