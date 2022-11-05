package Advanced_Arrays;

public class Minimum_Swaps {
    public static void main(String[] args){
//        int[] A={52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70};
        int[] A={31, 98, 58, 86, 36, 31, 3, 22, 4, 17, 51, 33, 56, 7, 91, 17, 59, 66, 54, 67, 55, 41, 58, 24, 100, 1, 98, 68, 21, 33, 27, 67, 20, 66, 20, 100, 36, 89, 20, 15, 13, 26, 11, 29, 99, 36, 39, 49, 74, 77, 54, 66, 30, 21, 14, 18, 83, 72, 10, 22, 53, 83, 60, 9, 68, 56, 9, 21, 77, 44, 45, 61, 97, 82, 35, 16, 38, 95, 55, 11, 46, 77, 25, 3, 44};
        int B=18; int last_index=0; int count_swaps=0; int min_count= A.length;
        int total_count=0;
        for(int i=0; i<A.length; i++){
          if(A[i] <= B)
              total_count++;
        }
        for(int i=0; i<total_count; i++){
            if(A[i]>B) count_swaps++;
        }
        min_count = Math.min(count_swaps,min_count);
        for(int i=total_count; i<A.length; i++){
            if(A[i]>B && A[last_index]<=B) count_swaps++;
            else if(A[i]<=B && A[last_index]>B) count_swaps--;
            min_count = Math.min(count_swaps,min_count);
            last_index++;
            }
        System.out.println(min_count);
    }
}
