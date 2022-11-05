package Advanced_Arrays;

import java.util.ArrayList;

public class AddNum {
    public static void main(String[] args){
        int[] A= {0,0, 6, 0, 6, 4, 8, 8, 1};
        int cf=0;
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=A.length-1; i>=0; i--){
            int num = A[i];
            if(i==A.length-1) num+=1;
            else num += cf;
            if(num > 9) {
                cf = num - 9;
                num = 0;
            }
            else cf=0;
            if(i==A.length-1) l.add(num);
            else l.add(0,num);
        }
        if(cf>0) l.add(0,cf);
        int k=0;
        while(l.get(0) == 0)
        {
            l.remove(0);
        }
        System.out.println(l);
    }
}
