package myStacks;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String str = "abcd";
        System.out.println(StringReverser.reverse(str));

        String str2 = "(()))))";
        System.out.println(BalancedExpressions.isBalanced(str2));

        myStacks stack = new myStacks();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.pop();

        System.out.println(stack);

    }





}
