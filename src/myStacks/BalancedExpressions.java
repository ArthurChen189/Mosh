package myStacks;


import java.util.Arrays;
import java.util.Stack;
import java.util.List;

public class BalancedExpressions {
    private static final List<Character> delimiter = Arrays.asList('(',')','[',']','<','>');

    public static boolean isBalanced(String str){
        if (str.length() == 0){
            throw new IllegalArgumentException("Gimme a legit string plz!");
        }
        Stack<Character> stack = new Stack<>();
        for (char i : str.toCharArray()) {
            if(!isDelimiter(i)) continue;
            if(i == ')' || i == ']' || i == '>'){
                if (stack.isEmpty()) return false;
                else if (isMatched(stack.peek(),i)){
                    stack.pop();
                    continue;
                }
                return false;
            }
            stack.push(i);
        }
        return stack.isEmpty();
    }

    private static boolean isDelimiter(char a){
        return delimiter.contains(a);
    }

    private static boolean isMatched(char a,char b){
        if (a == '(' && b == ')') return true;
        if (a == '[' && b == ']') return true;
        if (a == '<' && b == '>') return true;
        return false;
    }
}
