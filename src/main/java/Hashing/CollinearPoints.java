package Hashing;

import java.util.HashMap;

public class CollinearPoints {
    public static void main(String[] args) {
        int[] x_cords = {-39, 25, -17, -5, 16, 0, -17, -9, 21, -19, 11, -10, -18, 17, 37, -36, -36, 16, 41, 36, 42, 5, -35, 47, -33, 4, -30, 4, -7, 34, 31, 22, -48, -41, -37, -19, 27, 30, -19, 1, 7, -21};
        int[] y_cords = {37, -11, -46, -37, 32, 46, -30, -36, -20, -23, -5, 28, 4, -31, 9, 9, 9, 37, 34, 31, 9, -16, 6, -20, -27, -25, -35, 47, -6, 22, -49, 47, 8, 42, 49, -28, -47, 40, 7, -11, 44, -4};
        int number_of_points = x_cords.length;
        int max_collinear_pts = 0;
        for(int i=0; i<number_of_points; i++){
            HashMap<String,Integer> point_freq = new HashMap<>();
            int same_points =0; int max_freq = 0;
            for(int j=i+1; j<number_of_points; j++){
                int x1 = x_cords[i];
                int y1 = y_cords[i];
                int x2 = x_cords[j];
                int y2 = y_cords[j];

                if(x1 == x2 && y1 == y2){
                    same_points++;
                }
                else {
                    int slope_num = y2 - y1;
                    int slope_den = x2 - x1;
                    int gcd;
                    if (slope_den == slope_num) {
                        gcd = slope_den;
                    } else {
                        gcd = findGCD(slope_den, slope_num);
                    }
                    slope_num /= gcd;
                    slope_den /= gcd;
                    String slope = "";

                    if(slope_den==0){
                        slope = "Infinity";
                    }
                    else{
                        slope = Math.abs(slope_num) + "_" + Math.abs(slope_den);
                    }
                    int freq = 1;
                    if (point_freq.containsKey(slope)) {
                        freq = point_freq.get(slope) + 1;
                    }
                    point_freq.put(slope, freq);
                    max_freq = Math.max(max_freq, freq);
                }
            }
            int points = max_freq+same_points+1;
            max_collinear_pts = Math.max(points,max_collinear_pts);
        }
        System.out.println(max_collinear_pts);
    }

    private static int findGCD(int num1, int num2) {
        if(num2==0){
          return num1;
        }
        return findGCD(num2,num1%num2);
    }

}

