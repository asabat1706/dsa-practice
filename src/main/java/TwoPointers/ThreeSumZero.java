package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {
    public static void main(String[] args){
//        int[] A = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
//        int[] A={-31013930,9784175, 21229755};
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-31013930); A.add(-31013930); A.add(9784175); A.add(21229755);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Collections.sort(A);
        for(int a=0; a<A.size();){
            int b=a+1, c=A.size()-1;
            while(b<c){
                int sum=A.get(a) + A.get(b) + A.get(c);
                if(sum == 0){
                    ArrayList<Integer> l = new ArrayList<>();
                        l.add(A.get(a));
                        l.add(A.get(b));
                        l.add(A.get(c));
                        list.add(l);
                    int ind=b+1;
                    while(ind < c){
                        if(A.get(ind).equals(A.get(b))) {
                            ind++;
                        }
                        else break;
                    }
                    b=ind;
                }
                else{
                    if(sum > 0)
                        c--;
                    else b++;
                }
            }
            int index=a+1;
            while(index < A.size()){
                if(A.get(index).equals(A.get(a))) {
                    index++;
                }
                else break;
            }
            a=index;
        }
        System.out.println(list);
    }
}
