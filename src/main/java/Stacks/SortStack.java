package Stacks;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args){
        int[] A = {5, 17, 100, 11};
        Stack<Integer> inputStack = new Stack<>();

        for(int i=0; i<A.length; i++){
            inputStack.push(A[i]);
        }

        Stack<Integer> helperStack = new Stack<>();
        while(!inputStack.isEmpty()){
            int pop_input = inputStack.pop();
            while(!helperStack.isEmpty() && (helperStack.peek() < pop_input)){
                    int pop_helper = helperStack.pop();
                    inputStack.push(pop_helper);
            }
            helperStack.push(pop_input);
        }

        int[] ans = new int[A.length]; int index=0;
        while (!helperStack.isEmpty()){
            System.out.print(helperStack.peek() + "    ");
            ans[index++] = helperStack.pop();

        }
    }
}
