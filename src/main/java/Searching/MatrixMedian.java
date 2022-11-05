package Searching;

public class MatrixMedian {
    public static void main(String[] args){
        int[][] A = {{1,3,5}, {2,6,9}, {3,6,9}};
//        int[][] A = {{5, 17, 100}};
        int row=0, row_max= A.length-1;
        int ans = A[0][0];
        while(row <= row_max){
            int col=0, col_max = A[0].length-1;
            while(col <= col_max){
            int mid = col + (col_max-col)/2;
            int count_greater = findCount(A, A[row][mid]);
            int total = (A.length) * (A[0].length);
            total--;
            int count_smaller = (total - count_greater);
            if(count_smaller == count_greater) {
                  ans = A[row][mid];
                  break;
            }
            else if(count_smaller > count_greater) {
                    col_max = mid - 1;
                }
            else col = mid+1;
            }
            row++;
        }
        System.out.println(ans);
    }

    private static int findCount(int[][] a, int mid) {
         int r=0, r_max=a.length;
         int count=0;
         while(r < r_max){
                 int c_max=a[0].length-1;
                 if((a[r][c_max] >= mid) && (a[r][0] >= mid)){
                     count += a[0].length;
                 }
                 else if((a[r][c_max] > mid) && (a[r][0] < mid))
                 {
                     count = binarySearchCount(a,r,mid);
                 }
                 r++;
         }
         return count;
    }

    private static int binarySearchCount(int[][] a, int r, int mid) {
        int s=0, e=a[r].length-1; int ans=0;
        while(s<=e){
            int m= s + (e-s)/2;
            if(a[r][m]>= mid){
                ans = m;
                e = m-1;
            }
            else
                s=m+1;
        }
        return (a[r].length - ans);
    }

}

//    private static int countElement(int[][] a, int ele) {
//        int count=-0;
//        for(int row=0; row<a.length; row++){
//            if((a[row][0]> ele) && (a[row][a[row].length-1] > ele)) continue;
//            else if ((a[row][0] < ele) && (a[row][a[row].length-1] < ele)) continue;
//            else{
//                count += binaryCount(a,row,ele);
//                if(count > 1) return 2;
//            }
//        }
//        return count;
//    }
//
//    private static int binaryCount(int[][] a, int row, int ele) {
//        int first_index = binarySearchFirst(a,row,ele);
//        int last_index = binarySearchLast(a,row,ele);
//        if(first_index == last_index) {
//            if(first_index==-1) return 0;
//            else return 1;
//        }
//        else return 2;
//    }
//    private static int binarySearchLast(int[][] a, int row, int b) {
//        int s=0, e=a[0].length-1; int index=-1;
//        while(s <= e){
//            int mid = (s+e)/2;
//            if(a[row][mid]==b) {
//                index=mid;
//                s = (mid+1);
//            }
//            else if(a[row][mid]>b){
//                e=mid-1;
//            }
//            else{
//                s=mid+1;
//            }
//        }
//        return index;
//    }
//
//    private static int binarySearchFirst(int[][] a, int row, int b) {
//        int s=0, e=a[0].length-1; int index=-1;
//        while(s <= e){
//            int mid = (s+e)/2;
//            if(a[row][mid]==b) {
//                index=mid;
//                e=(mid-1);
//            }
//            else if(a[row][mid]>b){
//                e=mid-1;
//            }
//            else{
//                s=mid+1;
//            }
//        }
//        return index;
//    }

//        if(A[0].length==1){
//            int[] B = new int[A.length];
//            for(int i=0; i<B.length; i++)
//                B[i] = A[i][0];
//            Arrays.sort(B);
//            ans = B[B.length/2];
//        }

////
//private static boolean elementPresent(int[][] a, int ele) {
//    for(int row=0; row<a.length; row++){
//        if((a[row][0]> ele) && (a[row][a[row].length-1] >ele )) continue;
//        else if ((a[row][0] < ele) && (a[row][a[row].length-1] < ele) ) continue;
//        else{
//            boolean ispresent=binarySearch(a,row,ele);
//            if(ispresent) return true;
//        }
//    }
//    return false;
//}


//    private static boolean binarySearch(int[][] a, int row, int ele) {
//        int s=0, e=a[row].length-1;
//        while(s<=e){
//            int m= s + (e-s)/2;
//            if(a[row][m] == ele){
//                return true;
//            }
//            else if(a[row][m] > ele)
//                e = m-1;
//            else s = m+1;
//        }
//        return false;
//    }