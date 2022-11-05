package Stacks;

import java.util.Stack;

public class DoubleTrouble {
    public static void main(String[] args){
        String A = "abccbc";
        Stack<Character> char_stack = new Stack<>();
        for(char ch: A.toCharArray())
        {
            char ele = 0;
            if(!char_stack.isEmpty()){
                ele = char_stack.peek();
            }
            if(ele==ch){
                char_stack.pop();
            }
            else{
                char_stack.push(ch);
            }
        }
        StringBuilder ans= new StringBuilder();
        while(!char_stack.isEmpty()){
            ans.append(char_stack.pop());
        }
        ans.reverse();
        System.out.println(ans);
    }
}
