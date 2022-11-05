package Queues;

import java.util.*;

public class FirstNonRepeatingChar {
    public static void main(String[] args){
//        String A = "abcabbc";
//        String A = "xxikrsvskrib";
//        String A = "xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr";
        String A = "ptp";
        Deque<Character> dq = new LinkedList<>();
        HashMap<Character,Integer> hm = new HashMap();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            if(!hm.isEmpty() && hm.containsKey(ch)){
              hm.put(ch,hm.get(ch)+1);
            }
            else{
               hm.put(ch,1);
            }
            if(!dq.isEmpty() && (dq.peek() == ch)){
                while(hm.containsKey(dq.peekFirst()) && (hm.get(dq.peekFirst()) > 1))
                {
                    char first = dq.peekFirst();
                    dq.removeFirst();
                    hm.put(first,hm.get(first)-1);
                }
            }
            else{
                if(hm.containsKey(ch) && hm.get(ch) < 2)
                    dq.addLast(ch);
            }
            if(!dq.isEmpty())
              ans.append(dq.getFirst());
            else
              ans.append('#');
        }
        System.out.println(ans);
    }
}
