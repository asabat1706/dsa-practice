package Sorting;

import java.util.Arrays;

public class UniqueElements {
    public static void main(String[] args){
//        Out of memory error will be thrown for larger freq_arr size
        int[] A = {51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62 }; int count=0;
//        int[] A = {1,2,3,1,2,3,1,5,4,4,4};
        int max_length=A[0]; int ans=0;
        for(int i=1; i<A.length; i++){
            if(A[i] > max_length){
                max_length=A[i];
            }
        }
        int freq_arr[] = new int[max_length+1];
        for(int i=0; i<A.length; i++){
            freq_arr[A[i]]++;
        }
        for(int i=0; i<freq_arr.length-1; i++){
            if(freq_arr[i] > 1){
                int c = freq_arr[i];
                ans += (c-1);
                freq_arr[i+1] += (c-1);
            }
        }
        if(freq_arr[freq_arr.length-1] > 1){
            int c = freq_arr[freq_arr.length-1] - 1;
            ans += (c*(c+1))/2;
        }
        System.out.println(ans);
    }
}
