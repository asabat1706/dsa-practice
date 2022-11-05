package Stacks;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args){
        String A = "()[]";
        Stack<Character> s = new Stack<>();
        boolean isBalanced = false;
        for(char ch: A.toCharArray()){
            char top_ele = '0';
            if(!s.isEmpty()){
                top_ele = s.peek();
            }
            if((ch=='}' && top_ele=='{') || (ch==']' && top_ele=='[') || ch==')' && top_ele=='('){
                s.pop();
            }
            else{
                s.push(ch);
            }
        }
        if(s.isEmpty()) {
            isBalanced = true;
        }
        System.out.println(isBalanced);
    }
}
