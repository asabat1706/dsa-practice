package Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class BClosestPoints {
    public static void main(String[] args){
//        int[][] A = {{1,-1},{2,-1},{3,-1},{4,-1}};
        int[][] A = {{40,35},{31,40},{20,14},{50,45},{48,28},{17,44},{19,2},{19,2},{34,41},{44,47},{25,14},
                {44,7}};
        int B =11;
        TreeMap<Double,ArrayList<Integer>> hm = new TreeMap<>();
        for(int i=0; i<A.length; i++){
            int x = A[i][0]; int y = A[i][1];
            double dist = Math.sqrt((x*x)+(y*y));
            if(!hm.containsKey(dist)){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                hm.put(dist,l);
            }
            else{
                ArrayList<Integer> l = hm.get(dist);
                l.add(i);
                hm.put(dist,l);
            }
        }
        int[][] res = new int[B][2]; int row_index=0;
        Set<Double> keySet = hm.keySet();
        for(Double k : keySet){
            if(row_index < B) {
                ArrayList<Integer> indices = hm.get(k);
                for(Integer index : indices) {
                    if(row_index < B) {
                        res[row_index][0] = A[index][0];
                        res[row_index][1] = A[index][1];
                        row_index++;
                    }
                    else break;
                }
            }
            else break;
        }
        System.out.println(res);
    }
}
