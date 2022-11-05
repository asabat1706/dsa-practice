package Backtracking;

import java.util.ArrayList;

public class Permutations {
    static ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
    public static void main(String[] args){
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1); input.add(2); input.add(3);
        ArrayList<Integer> set = new ArrayList<>();
        generate_permut(input,set,0);
        System.out.println(permutations);
    }

    private static void generate_permut(ArrayList<Integer> input, ArrayList<Integer> set, int pos) {
        if(pos == (input.size()-1)){
            set.add(input.get(pos));
            ArrayList<Integer> list = new ArrayList<>(set);
            permutations.add(list);
            set.remove(set.size()-1);
            return;
        }
        for(int i=pos; i<input.size(); i++){
            swap(input, i, pos);
            set.add(input.get(pos));
            generate_permut(input, set, pos+1);
            set.remove(set.size()-1);
            swap(input, i, pos);
        }
    }

    private static void swap(ArrayList<Integer> input, int i, int pos) {
        int temp = input.get(pos);
        input.set(pos,input.get(i));
        input.set(i,temp);
    }
}
