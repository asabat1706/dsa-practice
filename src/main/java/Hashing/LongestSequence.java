package Hashing;

import java.util.Iterator;
import java.util.TreeSet;

public class LongestSequence {
    public static void main(String[] args){
        int[] A = {97, 86, 67, 19, 107, 9, 8, 49, 23, 46, -4, 22, 72, 4, 57, 111, 20, 52, 99, 2, 113, 81, 7, 5, 21, 0, 47, 54, 76, 117, -2, 102, 34, 12, 103, 69, 36, 51, 105, -3, 33, 91, 37, 11, 48, 106, 109, 45, 58, 77, 104, 60, 75, 90, 3, 62, 16, 119, 85, 63, 87, 43, 74, 13, 95, 94, 56, 28, 55, 66, 92, 79, 27, 42, 70};
        int max_len = 1;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0; i<A.length; i++){
            ts.add(A[i]);
        }
        Iterator itr = ts.iterator();
        int last = (int) itr.next(); int len=1;
        while(itr.hasNext()){
            int current = (int) itr.next();
            if(current == (last+1)) {
                len++;
            }
            else{
                len=1;
            }
            last = current;
            max_len = Math.max(len,max_len);
        }
        System.out.println(max_len);
    }
}
