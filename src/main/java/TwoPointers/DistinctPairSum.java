package TwoPointers;

public class DistinctPairSum {
    public static void main(String[] args){
        int[] A={1, 2, 3, 4, 5};
        int B=5; long count=0L;
        int s=0, e=A.length-1;
        while(s < e){
            int sum = A[s]+A[e];
            if(sum == B){
                count++;
                s++; e--;
            }
            else{
                if(sum > B) e--;
                else s++;
            }
        }
        System.out.println(count);
    }
}
