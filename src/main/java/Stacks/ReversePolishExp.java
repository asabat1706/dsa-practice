package Stacks;

import java.util.Stack;

public class ReversePolishExp {
    public static void main(String[] args){
        String[] A = {"4", "13", "5", "/", "+"};
        Stack<String> s = new Stack<>();
        int op =0;
        for(String ch:A){
            String op1 = "", op2 = "";
           if(ch.equals("+")){
               op1 = s.pop(); op2 = s.pop();
               op = Integer.parseInt(op1) + Integer.parseInt(op2);
               s.push(String.valueOf(op));
           }
           else if(ch.equals("-")){
               op2 = s.pop(); op1 = s.pop();
               op = Integer.parseInt(op1) - Integer.parseInt(op2);
               s.push(String.valueOf(op));
           }
           else if(ch.equals("/")){
               op1 = s.pop(); op2 = s.pop();
               op = Integer.parseInt(op2) / Integer.parseInt(op1);
               s.push(String.valueOf(op));
           }
           else if(ch.equals("*")){
               op1 = s.pop(); op2 = s.pop();
               op = Integer.parseInt(op1) * Integer.parseInt(op2);
               s.push(String.valueOf(op));
           }
           else
           {
               s.push(ch);
           }

        }
        System.out.println(s.pop());
    }
}
