package Hashing;
import java.util.HashMap;

public class MinimumDistance {
    public static void main(String[] args){
       int[] A = {7, 1, 3, 4, 1, 7};
       int min_dis = Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(!hm.containsKey(A[i])){
                hm.put(A[i],i);
            }
            else{
                int dis = i - hm.get(A[i]);
                min_dis = Math.min(min_dis,dis);
                hm.put(A[i],i);
            }
        }
        if(min_dis == Integer.MAX_VALUE) min_dis=-1;
        System.out.println(min_dis);
    }
}
