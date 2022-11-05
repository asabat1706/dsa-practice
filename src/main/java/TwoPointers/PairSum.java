package TwoPointers;

public class PairSum {
    public static void main(String[] args){
        int[] A = {1, 1};
        int B=2;
        long count=-0L;
        int s=0, e=A.length-1;
        while(s<e){
            int sum=A[s]+A[e];
            if(sum == B) {
                if(s != e) {
                    //find duplicates from start
                    int dup = s;
                    while (dup < e) {
                        if (A[dup] == A[s]) {
                            count++;
                            dup++;
                        }
                        else break;
                    }
                    e--;
                }
            }
            else{
                if(sum > B) e--;
                else s++;
            }
        }
        System.out.println(count);
    }
}
