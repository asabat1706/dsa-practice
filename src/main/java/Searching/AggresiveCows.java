package Searching;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args){
        int[] A ={5, 17, 100, 11};
        Arrays.sort(A);
        int B=2; int ans=0;
        int s= 1,  e=A[A.length-1]-A[0];
        while(s<=e){
            int mid = s + (e-s)/2;
            if(check(A,mid,B)){
                ans = mid;
                s = mid+1;
            }
            else
                e = mid-1;
        }
        System.out.println(ans);
    }

    private static boolean check(int[] a, int mid, int noOfCows) {
        int lastPlaced = a[0];
        int cowsPlaced = 1;
        for(int i=1; i<a.length; i++){
            if((a[i] - lastPlaced) >= mid){
                cowsPlaced++;
                lastPlaced = a[i];
            }
            if(cowsPlaced==noOfCows) return true;
        }
        return false;
    }
}
