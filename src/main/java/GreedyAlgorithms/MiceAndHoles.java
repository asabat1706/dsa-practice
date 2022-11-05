package GreedyAlgorithms;

import java.util.Arrays;

public class MiceAndHoles {
    public static void main(String[] args){
        int[] rats = {-4,1,-2,7,0};
        int[] holes = {2,8,4,-6,1};

        Arrays.sort(rats);
        Arrays.sort(holes);
        int max_dist= Integer.MIN_VALUE;

        for(int i=0; i<rats.length; i++){
            int dist = Math.abs(rats[i] - holes[i]);
            max_dist = Math.max(dist,max_dist);
        }

        System.out.println(max_dist);
    }
}
