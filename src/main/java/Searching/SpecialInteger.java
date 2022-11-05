package Searching;

import java.util.ArrayList;

public class SpecialInteger {
    static ArrayList<Long> al = new ArrayList<>();
    public static void main(String[] args){
        int[] A = {5, 17, 100, 11};
        int B=130;
        for(int i=0; i<A.length; i++){
            al.add(0L);
        }
        al.set(0,(long)A[0]);
        for(int i=1; i<A.length; i++){
            long temp = A[i]+al.get(i-1);
            al.set(i,temp);
        }
        int s=1, e=A.length;
        int ans = 0;
        while(s <= e){
            int mid = s + (e-s)/2;
            long max_sum = findSubarrayMaxSum(al,mid);
            if(max_sum == (long)B){
                ans = mid;
                break;
            }
            else if(max_sum < B){
                ans = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        System.out.println(ans);
    }

    private static long findSubarrayMaxSum(ArrayList<Long> a, int mid) {
        long max_sum= Integer.MIN_VALUE;
        int start = -1;
        for(int i=mid-1; i<a.size(); i++){
          if(start == -1) max_sum = Math.max(max_sum,a.get(i));
          else max_sum = Math.max(max_sum,a.get(i)-a.get(start));
          start++;
        }
        return max_sum;
    }
}
