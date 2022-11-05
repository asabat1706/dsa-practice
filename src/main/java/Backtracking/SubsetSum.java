package Backtracking;

import java.util.HashSet;

public class SubsetSum {
    static int count=0;
//    static HashSet<Integer> ans = new HashSet();
    static int sum=0;
    public static void main(String[] args){
//        int[] A = {1,2,-4,9,6,-1,3};
//        int[] A = {-1,2,3};
        int[] A={8, 10, 6, 11, 1, 16, 8};
        int k = 28;
        generateSubset(A.length,A,0, k);
        System.out.println(count);
    }

    private static void generateSubset(int length, int[] a, int index, int k) {
        if(index == length){
            if(sum == k){
//                System.out.println(ans);
                count++;
            }
            return;
        }
//        ans.add(a[index]);
        sum = sum + a[index];
        generateSubset(length, a, index+1, k);
//        ans.remove(a[index]);
        sum = sum - a[index];
        generateSubset(length,a,index+1,k);
    }
}
