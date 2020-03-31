package myQueues;

import java.util.Stack;

/*
Objective: Use two stacks to implement a queue
 */
public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    //O(1)
    public void enqueue(int item){
        stack1.push(item);
    }

    //O(n)
    public int dequeue(){
        if (isEmpty()){
            throw new IllegalStateException();
        }

        moveStack1ToStack2();
        return stack2.pop();
    }

    public int peek(){
        if (isEmpty()){
            throw new IllegalStateException();
        }

        moveStack1ToStack2();
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
