package Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestUniquePrefix {
    public static void main(String[] args){
        String[] A = {"zebra", "dog", "duck", "dove"};
        String[] ans = new String[A.length];
        TriePrefixNode dummy = new TriePrefixNode('$');
        for(int i=0; i<A.length; i++){
            insertIntoTrie(dummy,A[i]);
        }
        int index=0;
        for(int i=0; i<A.length; i++){
            String pre = searchPrefixinTrie(dummy,A[i]);
            ans[index++] = pre;
        }
    }

    private static String searchPrefixinTrie(TriePrefixNode dummy, String s) {
        TriePrefixNode curr = dummy;
        StringBuilder prefix = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            TriePrefixNode child = curr.children.get(ch);
            prefix.append(ch);
            if(child.visted == 1){
                return prefix.toString();
            }
            curr = curr.children.get(ch);
        }
        return prefix.toString();
    }

    private static void insertIntoTrie(TriePrefixNode dummy, String s) {
        TriePrefixNode curr = dummy;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!curr.children.containsKey(ch)){
                TriePrefixNode child = new TriePrefixNode(ch);
                child.visted  = 1;
                curr.children.put(ch,child);
            }
            else{
                TriePrefixNode child = curr.children.get(ch);
                child.visted++;
                curr.children.put(ch,child);
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd=true;
    }

}
class TriePrefixNode{
    char ch;
    HashMap<Character, TriePrefixNode> children;
    boolean isEnd;
    int visted;
    public TriePrefixNode(char ch){
        this.ch = ch;
        children = new HashMap<>();
        isEnd = false;
        visted = 0;
    }
}
