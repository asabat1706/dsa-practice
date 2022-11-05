package Trees;

import java.util.*;

public class AutoComplete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number_of_tests = sc.nextInt();
        for (int i = 0; i < number_of_tests; i++) {
            int dictionary_size = sc.nextInt();
            int prefix_size = sc.nextInt();
            String[] dictionary = new String[dictionary_size];

            List<String> prefix_list = new ArrayList<>();
            TreeMap<Integer, String> word_weight = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            for (int j = 0; j < dictionary_size; j++) {
                dictionary[j] = sc.next();
            }

            for (int j = 0; j < dictionary_size; j++) {
                int weight = sc.nextInt();
                word_weight.put(weight, dictionary[j]);
            }

            for (int j = 0; j < prefix_size; j++) {
                prefix_list.add(sc.next());
            }
            System.out.println(prefix_list);
            System.out.println(word_weight);
            PrefixTrieNode dummy = new PrefixTrieNode('$');
            for (Integer s : word_weight.keySet()) {
                insertIntoTrie(dummy, word_weight.get(s));
            }
            for (String s : prefix_list) {
                ArrayList<String> max_wght_words = searchTriePrefix(dummy, s);
                if (max_wght_words == null) System.out.print(-1);
                else {
                    for (String ps : max_wght_words) {
                        System.out.print(ps + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static ArrayList searchTriePrefix(PrefixTrieNode dummy, String s) {
        PrefixTrieNode curr = dummy;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!curr.children.containsKey(ch)) {
                return null;
            }
            if (i == s.length() - 1) return curr.children.get(ch).most_weighted_words;
            else curr = curr.children.get(ch);
        }
        return null;
    }

    private static void insertIntoTrie(PrefixTrieNode dummy, String s) {
        PrefixTrieNode curr = dummy;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!curr.children.containsKey(ch)) {
                PrefixTrieNode child = new PrefixTrieNode(ch);
                child.most_weighted_words.add(s);
                curr.children.put(ch, child);
            } else {
                PrefixTrieNode child = curr.children.get(ch);
                if (child.most_weighted_words.size() < 5) {
                    child.most_weighted_words.add(s);
                }
                curr.children.put(ch, child);
            }
            curr = curr.children.get(ch);
        }
    }
}

 class PrefixTrieNode{
    char ch;
    HashMap<Character,PrefixTrieNode> children;
    boolean isEnd;
    ArrayList<String> most_weighted_words;

    public PrefixTrieNode(char ch){
        this.ch = ch;
        this.children = new HashMap<>();
        isEnd = false;
        most_weighted_words = new ArrayList<>();
    }
 }