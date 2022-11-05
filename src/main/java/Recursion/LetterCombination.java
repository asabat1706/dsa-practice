package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
    static List<String> letter_combs = new ArrayList<>();
    public static void main(String[] args){
        String input = "012";
        HashMap<Character, String> num_letters_dict = new HashMap<>();
        num_letters_dict.put('0',"0");
        num_letters_dict.put('1',"1");
        num_letters_dict.put('2',"abc");
        num_letters_dict.put('3',"def");
        num_letters_dict.put('4',"ghi");
        num_letters_dict.put('5',"jkl");
        num_letters_dict.put('6',"mno");
        num_letters_dict.put('7',"pqrs");
        num_letters_dict.put('8',"tuv");
        num_letters_dict.put('9',"wxyz");

        HashMap<Character, String> updatedInput = new HashMap<>();
        for(char ch: input.toCharArray()){
            String p = num_letters_dict.get(ch);
            updatedInput.put(ch,p);
        }
        StringBuilder ans = new StringBuilder();
        generateCombinations(input,updatedInput,0,ans);
        System.out.println(letter_combs);
    }

    private static void generateCombinations(String input,HashMap<Character, String> updatedInput, int index, StringBuilder ans) {
        if(index == updatedInput.size()){
           letter_combs.add(ans.toString());
           return;
        }
        String str = updatedInput.get(input.charAt(index));
        for(char ch: str.toCharArray()){
           ans.append(ch);
           generateCombinations(input,updatedInput,index+1,ans);
           ans.deleteCharAt(ans.length()-1);
        }

    }
}
