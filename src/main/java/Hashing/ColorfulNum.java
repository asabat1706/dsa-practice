package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ColorfulNum {
    public static void main(String[] args){
       int A= 12345;
       int ans= colorful(A);
        System.out.println(ans);
    }
    public static int colorful(int A) {
        Map<Integer,Integer> hm = new HashMap<>();
        while(A>0){
            int n=(int)A%10;
            if(!hm.containsKey(n)){
                hm.put(n,1);
            }
            else{
                int c = hm.get(n);
                hm.put(n,c+1);
            }
            A = (int)A/10;
        }
        if(!hm.containsKey(1)){
            while(A>0){
                int n = (int)A%10;
                // System.out.println("n--" +n);
                for(int i=0; i<(int)Math.sqrt(n);i++)
                {
                    if(n%i==0){
                        int f1 = i;
                        int f2 = (n/i);
                        if(f1 != f2){
                            if(hm.containsKey(f1) && hm.containsKey(f2))
                                return 0;
                        }
                        else{
                            int c = hm.get(f1);
                            if(hm.containsKey(f1) && c>=2){
                                return 0;
                            }
                        }
                    }
                }
                A = (int)A/10;
            }
            return 1;
        }
        else
            return 0;
    }
}
