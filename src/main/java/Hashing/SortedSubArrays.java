package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class SortedSubArrays {
    static HashMap<Integer,Long> hashValues = new HashMap<>();
    static HashSet<Long> uniqueHash = new HashSet();
    public static void main(String[] args) {
        int[] input = {1, 7, 11, 8, 11, 7, 1};
        int[][] queries = {{0,2,4,6}};

        long[] prefix_sum = new long[input.length];
        int[] ans = new int[queries.length];

        for (int i = 0; i < input.length; i++) {
            if (!hashValues.containsKey(input[i])) {
                long hash_value = generateHashCode(input[i]);
                hashValues.put(input[i], hash_value);
            }
        }

        for(int i=0; i< input.length; i++){
            if(i==0) {
                prefix_sum[i] = hashValues.get(input[i]);
            }
            else{
                prefix_sum[i] = prefix_sum[i-1]+ hashValues.get(input[i]);
            }
        }

        for(int i=0; i< queries.length; i++){
            int start1 = queries[i][0];
            int end1 = queries[i][1];
            int start2 = queries[i][2];
            int end2 = queries[i][3];

            long sum_1 = 0L;
            if(start1 == 0){
                sum_1 = prefix_sum[end1];
            }
            else{
                sum_1 = prefix_sum[end1] - prefix_sum[start1-1];
            }
            long sum_2 = 0L;
            if(start2 == 0){
                sum_2 = prefix_sum[end2];
            }
            else{
                sum_2 = prefix_sum[end2] - prefix_sum[start2-1];
            }

            if(sum_1 == sum_2){
                ans[i] = 1;
            }
            else{
                ans[i] = 0;
            }
        }

        for(int i=0; i< ans.length; i++){
            System.out.print(ans[i] + "   ");
        }

    }
    private static long generateHashCode(int num) {
        Random rand = new Random();
        long random_num = rand.nextLong();
        while(uniqueHash.contains(random_num)){
            random_num = rand.nextLong();
        }
        return random_num;
    }
}
