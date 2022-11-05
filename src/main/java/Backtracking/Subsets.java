package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Subsets {
    static ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3); A.add(2); A.add(1);
        Collections.sort(A);
        ArrayList<Integer> subset = new ArrayList<>();
        generateSubsets(A,0, subset);
        subsets.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int i=0;
                    int size = Math.min(o1.size(), o2.size());
                    while((i < size)){
                        if(o1.get(i) < o2.get(i)){
                            return -1;
                        }
                        else if(o1.get(i) > o2.get(i)){
                            return 1;
                        }
                        else{
                            i++;
                        }
                    }
                    if(o1.size() > o2.size()){
                        return 1;
                    }
                    else if(o1.size() < o2.size()){
                        return -1;
                    }
                    return 0;
            }
        });
        System.out.println(subsets);
    }

    private static void generateSubsets(ArrayList<Integer> a, int index, ArrayList<Integer> subset) {
        if(index==a.size()){
            ArrayList<Integer> list = new ArrayList<>(subset);
            subsets.add(list);
            return;
        }
        subset.add(a.get(index));
        generateSubsets(a,index+1,subset);
        subset.remove(subset.size()-1);
        generateSubsets(a,index+1,subset);
    }
}
