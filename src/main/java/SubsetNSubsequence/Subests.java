package SubsetNSubsequence;

import java.util.*;

public class Subests {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1); list.add(2); list.add(3);
        list.add(16); list.add(17); list.add(7); list.add(3); list.add(6);
        list.add(18); list.add(5); list.add(13); list.add(4);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for(int i=0; i<(int)Math.pow(2,list.size()); i++){
            ArrayList<Integer> subset = new ArrayList<>();
            for(int j=0; j<list.size(); j++){
                if(((i>>j)&1)==1) subset.add(list.get(j));
            }
            Collections.sort(subset);
            subsets.add(subset);
        }
        subsets.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(!o1.isEmpty() && !o2.isEmpty()) {
                    int min_size = Math.min(o1.size(), o2.size());
                    for(int i=0; i<min_size; i++){
                        if(o1.get(i)==o2.get(i)) continue;
                        else if(o1.get(i) < o2.get(i)) return -1;
                        else return 1;
                    }
                }
                else if (o1.isEmpty()) return -1;
                else return 1;
                return 0;
            }
        });
        System.out.println(subsets);
    }
}
