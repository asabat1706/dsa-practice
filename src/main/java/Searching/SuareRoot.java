package Searching;

public class SuareRoot {
    public static void main(String[] args){
        int A=2147483647;
        int s=1,e=A; int ans=-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(((long) mid *mid) == (long)A){
                ans= mid;
                break;
            }
            else if(((long) mid *mid) < (long)A){
                ans = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        System.out.println(ans);
    }
}
