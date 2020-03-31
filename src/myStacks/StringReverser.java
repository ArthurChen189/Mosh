package myStacks;

import java.util.Stack;

public class StringReverser {
    public static String reverse(String str){
        if (str.length() == 0){
            throw new IllegalArgumentException("Yo, gimme a non-empty string");
        }

        Stack<Character> stack = new Stack<>();
        for (char i : str.toCharArray()) {
            stack.push(i);
        }
        StringBuffer output = new StringBuffer();
        while(!stack.isEmpty()){
            output.append(stack.pop());
        }
        return output.toString();
    }
}
