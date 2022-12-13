package Trees;

import java.util.Set;

public class ModifiedSearch {
    public static void main(String[] args){
        String[] dictionary = {"hello", "world"};
        String[] words = {"hella", "pello", "pella"};

        StringBuilder answer = new StringBuilder("");
        TrieNode dictionary_root = new TrieNode('$');

        for(String word : dictionary){
            insertIntoTrie(dictionary_root,word);
        }

        for(String word : words){
            boolean singleMismatch = checkSingleMisMatch(dictionary_root,word,0,0);
            if(singleMismatch){
                answer.append('1');
            }
            else{
                answer.append('0');
            }
        }
        System.out.println(answer);
    }

    private static boolean checkSingleMisMatch(TrieNode current, String word, int idx, int mismatchCount) {
        if(current == null){
            return false;
        }
        if(current.isEnd && idx != word.length()){
            return false;
        }
        if(idx == word.length()){
            return current.isEnd && mismatchCount==1;
        }
        char ch = word.charAt(idx);
        boolean isFound = false;
        Set<Character> children_chars = current.children.keySet();
        for(char children_char: children_chars){
            if(ch == children_char){
                isFound = checkSingleMisMatch(current.children.get(children_char),word,idx+1,mismatchCount);
            }
            else{
                mismatchCount++;
                isFound = checkSingleMisMatch(current.children.get(children_char),word,idx+1,mismatchCount);
                mismatchCount--;
            }
            if(isFound){
                return true;
            }
        }
        return false;
    }


    private static void insertIntoTrie(TrieNode root, String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.children.containsKey(ch)){
                current.children.put(ch,new TrieNode(ch));
            }
            current = current.children.get(ch);
        }
        current.isEnd=true;
    }
}

