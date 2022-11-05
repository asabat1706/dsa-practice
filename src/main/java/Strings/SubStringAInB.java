package Strings;

import java.util.HashMap;

public class SubStringAInB {
    public static void main(String[] args){
        String A = "docp";
        String B = "aoapeooeoapcpaocecddoocdcqqapeapccc";
        int k=A.length();
        HashMap<Character,Integer> a = new HashMap<>();
        HashMap<Character,Integer> b = new HashMap<>();
        for(char ch:A.toCharArray()){
            if(!a.containsKey(ch))
                a.put(ch,1);
            else{
                a.put(ch,a.get(ch)+1);
            }
        }
        int s=0, e=k-1;
        for(int i=s; i<=e; i++){
            char ch = B.charAt(i);
            if(!b.containsKey(ch))
                b.put(ch,1);
            else{
                b.put(ch,b.get(ch)+1);
            }
        }
        boolean ispresent=true; int count=0;
        for(char ch:a.keySet()){
            int actual=0, expected=0;
            if(a.containsKey(ch))
              expected = a.get(ch);
            if(b.containsKey(ch))
              actual = b.get(ch);
            if(expected!=actual){
                ispresent=false;
                break;
            }
        }
        if(ispresent) count++;
        while(s < (B.length()-k)){
            char removed_char = B.charAt(s);
            int c = b.get(removed_char);
            if(c > 1) b.put(removed_char,c-1);
            else b.remove(removed_char);
            s++;
            e++;
            char added_char = B.charAt(e);
            if(!b.containsKey(added_char))
                b.put(added_char,1);
            else b.put(added_char,b.get(added_char)+1);
            ispresent=true;
            if(a.size()!=b.size()) ispresent=false;
            else
            for(char ch:a.keySet()){
                int expected=0,actual=0;
                if(a.containsKey(ch))
                  expected = a.get(ch);
                if(b.containsKey(ch))
                  actual = b.get(ch);
                if(expected!=actual) {
                    ispresent=false;
                    break;
                }
            }
            if(ispresent) count++;
        }
        System.out.println("count "+count);
    }
}
