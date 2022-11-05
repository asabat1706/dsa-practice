package Trees;

import java.util.HashMap;

public class SearchWordInDictionary {
    public static void main(String[] args){
        String[] A = {"hat", "cat", "rat"};
        String[] B = {"cat", "ball"};
        int[] ans = new int[B.length];
        TrieNode dummy = new TrieNode('$');
        for(String word : A){
            insertIntoTrie(dummy,word);
        }
        int index =0;
        for(String word : B){
            int ispresent =  searchInTrie(dummy,word);
            ans[index] = ispresent;
            index++;
        }
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+ "   ");
        }
    }

    private static int searchInTrie(TrieNode dummy, String word) {
        TrieNode curr =  dummy;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)){
                return 0;
            }
            curr = curr.children.get(ch);
        }
        if(curr.isEnd) return 1;
        return 0;
    }

    private static void insertIntoTrie(TrieNode dummy, String word) {
        TrieNode curr =  dummy;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode(ch));
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd=true;
    }
}
class TrieNode{
    char ch;
    HashMap<Character,TrieNode> children;
    boolean isEnd;
    public TrieNode(char ch){
        this.ch = ch;
        children = new HashMap<>();
        isEnd = false;
    }
}