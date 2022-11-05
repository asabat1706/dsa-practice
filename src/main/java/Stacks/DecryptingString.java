package Stacks;

import javafx.util.Pair;

import java.util.Stack;

public class DecryptingString {
    public static void main(String[] args) {
        String str = "3a2bc";
        char ans = '!';
        int k = 3;
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        int len = 1;
        for (int i = 0; i < str.length(); i++) {
            if (len <= k) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    Pair<Character, Integer> p = new Pair<>(str.charAt(i), len++);
                    stack.push(p);
                } else {
                    len = (len-1) * Character.getNumericValue(str.charAt(i));
                    Pair<Character, Integer> p = new Pair<>('$', len++);
                    stack.push(p);
                }
            } else break;
        }
        while (!stack.isEmpty()) {
            while (k < stack.peek().getValue()) {
                stack.pop();
            }
            if (stack.peek().getKey() == '$') {
                stack.pop();
            }
            if ((k == stack.peek().getValue())) {
                ans = stack.peek().getKey();
                break;
            } else {
                k = k % stack.peek().getValue();
                if(k==0){
                    ans = stack.peek().getKey();
                    break;                }
            }
        }
        System.out.println(ans);
    }
}
