package Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactFinder {
    public static void main(String[] args){
        int[] actions = {0,0,1,1};
        String[] contactNames = {"s", "ss","s","ss"};
        ArrayList<Integer> contacts = new ArrayList<>();

        ContactTrie root = new ContactTrie('#');
        for(int i=0; i<actions.length; i++){
            if(actions[i] == 0){
                insertIntoTrie(root,contactNames[i]);
            }
            else if(actions[i] == 1){
                int nameCount = countNames(root,contactNames[i]);
                contacts.add(nameCount);
            }
        }
        System.out.println(contacts);
    }

    private static int countNames(ContactTrie root, String contactName) {
        ContactTrie current = root;
        for(char ch:contactName.toCharArray()){
            if(current.children.containsKey(ch)){
               current = current.children.get(ch);
            }
            else{
                return 0;
            }
        }
        return current.visitCount;
    }

    private static void insertIntoTrie(ContactTrie root, String contactName) {
        ContactTrie current = root;
        for(char ch : contactName.toCharArray()){
            if(!current.children.containsKey(ch)){
                current.children.put(ch, new ContactTrie(ch));
            }
            current = current.children.get(ch);
            current.visitCount++;
        }
        current.isEnd=true;
    }
}

class ContactTrie{
    char ch;
    HashMap<Character,ContactTrie> children;
    boolean isEnd;
    int visitCount;

    public ContactTrie(char ch){
        this.ch=ch;
        children = new HashMap<>();
        isEnd=false;
        visitCount=0;
    }

}
