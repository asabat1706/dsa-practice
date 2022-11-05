package Searching;

import java.util.Arrays;

public class MatrixMedian2 {
    public static void main(String[] args){
//        int[][] A = {{1,3,4}, {2,6,9}, {3,6,9}};
//        int[][] A = {{1,16,19}, {5,12,17}, {5,27,29}};
//        int[][] A = {{5}};
//        int[][] A ={{2, 2, 2, 2, 3, 3, 3}};
//        int[][] A = {{2},{1},{4},{1},{2},{2},{5}};
//        int[][] A = {{1, 1, 2, 9, 10, 12, 12, 17, 21, 22, 30},
//                {2, 3, 5, 7, 8, 12, 21, 25, 26, 27, 30},
//                {1, 3, 12, 13, 13, 14, 17, 18, 21, 21, 23}};
        int[][] A = {{9, 10, 10, 13, 14, 15, 16, 16, 16, 17, 18},
                {1, 4, 9, 14, 16, 18, 19, 22, 26, 26, 27},
                {4, 6, 7, 10, 14, 20, 21, 23, 24, 27, 28}};
        int ans = Integer.MAX_VALUE;
        if(A.length==1) ans = A[A.length/2][A[0].length/2];
        else {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int row=0; row<A.length; row++){
                min = Math.min(min, A[row][0]);
            }
            for(int row=0; row<A.length; row++){
                max = Math.max(min, A[row][A[row].length-1]);
            }
            int expected = ((A.length * A[0].length) / 2)+1;
            while (min <= max) {
                int mid = min + (max - min) / 2;
                int count_smaller = findCount(A, mid);
                if (count_smaller < expected)
                     min = mid + 1;
                else {
                    ans=mid;
                    max = mid - 1;
                }
            }
        }
        System.out.println(ans);
    }

    private static int findCount(int[][] a, int mid) {
        int r=0, r_max=a.length;
        int count=0;
        while(r < r_max){
//            int c_max=a[0].length-1;
//            if((a[r][c_max] > mid) && (a[r][0] > mid)){
//                count += a[0].length;
//            }
//            else if((a[r][c_max] < mid) && (a[r][0] <= mid)) {
//                count += 0;
//            }
//            else if((a[r][c_max] >= mid) && (a[r][0] <= mid))
//            {
                count += binarySearchCount(a,r,mid);
//            }
            r++;
        }
        return count;
    }

    private static int binarySearchCount(int[][] a, int r, int mid) {
        int s=0, e=a[r].length-1; int ans=0;
        while(s<=e){
            int m= s + (e-s)/2;
            if(a[r][m] <= mid){
                ans = m+1;
                s=m+1;
            }
            else
                e = m-1;
        }
        return (ans);
    }
}
