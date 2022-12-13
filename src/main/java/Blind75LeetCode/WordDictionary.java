package Blind75LeetCode;

import java.util.HashMap;
import java.util.Set;

public class WordDictionary {
    static TrieNode root = new TrieNode('$');
    public static void main(String[] args){
//        addWord("dad");
        addWord("bad");
//        addWord("sad");
        StringBuilder worFormed = new StringBuilder();
        boolean isPresent = searchWordInTrie(".ad",0,root);
        System.out.println(isPresent);
        isPresent = searchWordInTrie("..d",0,root);
        System.out.println(isPresent);
//        isPresent = searchWordInTrie("pad",0,root);
//        System.out.println(isPresent);

        String s = "1$2$3$N$N$4$5$N$N$N$N$";
        String[] s1 = s.split("\\$");
        for(String s2 : s1){
            System.out.println(s2);
        }
    }
    public static void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode(ch));
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

    public static boolean searchWordInTrie(String word, int idx, TrieNode current){
        //base case
        if(idx == word.length()){
            if(current.isEnd){
                return true;
            }
            return false;
        }
        boolean isFound  = false;

        if(word.charAt(idx) == '.'){
            Set<Character> childSet = current.children.keySet();
            for(Character child : childSet){
                TrieNode childNode = current.children.get(child);
                    isFound = searchWordInTrie(word, idx+1, childNode);
                    if(isFound){
                        return true;
                    }
                }
        }
        else{
            if(current.children.containsKey(word.charAt(idx))){
                TrieNode childNode = current.children.get(word.charAt(idx));
                isFound = searchWordInTrie(word, idx+1, childNode);
                if(isFound){
                    return true;
                }
            }
            else{
                return false;
            }
        }
        return isFound;
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
