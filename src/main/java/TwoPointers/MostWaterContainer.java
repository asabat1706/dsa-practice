package TwoPointers;

public class MostWaterContainer {
    public static void main(String[] args){
        int[] A={1, 5, 4, 3};
        int s=0, e=A.length-1;
        int max_area = Integer.MIN_VALUE;
        if(A.length>1) {
            while (s < e) {
                int area =  (e - s) * (Math.min(A[s], A[e]));
                max_area = Math.max(area, max_area);
                if (A[e] >= A[s]) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        else max_area=0;
        System.out.println(max_area);
    }
}
