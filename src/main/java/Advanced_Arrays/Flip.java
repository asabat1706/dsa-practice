package Advanced_Arrays;

import java.util.ArrayList;

public class Flip {
    public static void main(String[] args){
//        String A="0010110001";
        String A = "1101010001";
        int l=0; int lg= 0; int rg=-1;
        int count_0 = 0, count_1=0, count=0;
        int max_count = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == '0'){
                count_0++;
            }
            else count_1++;
            count = count_0-count_1;
            if(count < 0) {
                count_0=0;
                count_1=0;
                l = i+1;
            }
            else if(count > max_count){
                lg = l;
                rg = i;
                max_count = count;
            }
        }
        if(rg!= -1) {
            indices.add(lg + 1);
            indices.add(rg + 1);
        }
        System.out.println(indices);
    }
}
