package Advanced_Arrays;

import java.util.ArrayList;

public class PositiveSum {
    public static void main(String[] args){
        long max_sum =-1;
        int A[] = {1967513926, 1540383426, -1303455736, -521595368};
        long sum=0;
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> l_max = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            if(A[i] < 0){
                sum = 0;
                l = new ArrayList<>();
            }
            else{
                sum += A[i];
                l.add(A[i]);
            }

            if( (max_sum < sum) || (max_sum==sum && (l.size()>l_max.size()))) {
                max_sum = sum;
                l_max.clear();
                l_max.addAll(l);
            }
        }

        System.out.println(l_max);
    }
}
