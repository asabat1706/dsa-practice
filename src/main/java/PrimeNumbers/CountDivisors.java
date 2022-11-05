package PrimeNumbers;

import java.util.HashMap;
import java.util.Set;

public class CountDivisors {
    public static void main(String[] args){
        int[] A={8,9,10};
        int max = A[0];
        int[] divs=new int[A.length];
        for(int i=0; i<A.length; i++){
            if(A[i]>max)
                max = A[i];
        }
        int[] min_divs=new int[max+1];
        for(int i=0; i<min_divs.length; i++){
            min_divs[i]=i;
        }
        for(int i=2; i<=max; i++){
            if(min_divs[i]==i){
                for(int j=2*i; j<=max; j+=i){
                    if(min_divs[j]==j)
                        min_divs[j]=i;
                }
            }
        }
        for(int i=0; i<A.length; i++){
            if(min_divs[A[i]]==A[i]){
                if(A[i]==1) divs[i]=1;
                else divs[i]=2;
            }
            else{
                int dividend = A[i];
                HashMap<Integer,Integer> hm = new HashMap<>();
                while(dividend>1){
                 int min_d = min_divs[dividend];
                 dividend = dividend/min_d;
                 if(!hm.containsKey(min_d))
                     hm.put(min_d,1);
                 else hm.put(min_d, hm.get(min_d)+1);
                }
                Set<Integer> keys = hm.keySet();
                int count_divs=1;
                for(Integer key:keys){
                    count_divs *= (hm.get(key)+1);
                }
                divs[i] = count_divs;
            }
        }
        for(int i=0; i<divs.length; i++ ){
            System.out.print(divs[i]+ "   ");
        }
    }
}
