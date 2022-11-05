package Hashing;

import java.util.HashMap;

public class CollinearPts {
    public static void main(String[] args){
        int[] x_cords = {2, 1, -7, 4, 1, -2, -7, 5};
        int[] y_cords = {-6, -7, 3, -10, 7, -10, 1, 2};

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i<x_cords.length; i++){
            for(int j=i+1; j< y_cords.length; j++){
                int slope_num = y_cords[j]-y_cords[i];
                int slope_den = x_cords[j]-x_cords[i];
                int gcd;
                if(Math.abs(slope_den)==Math.abs(slope_num)){
                    gcd = 1;
                }
                else if(Math.abs(slope_den)>Math.abs(slope_num)){
                    gcd = findGCD(Math.abs(slope_den),Math.abs(slope_num));
                }
                else{
                    gcd = findGCD(Math.abs(slope_num),Math.abs(slope_den));

                }
                slope_num = slope_num/gcd;
                slope_den = slope_den/gcd;
                String slope = slope_num + " _ " + slope_den;
                if(!map.containsKey(slope)){
                    map.put(slope,0);
                }else{
                    map.put(slope,0);
                }
            }
        }
    }

    private static int findGCD(int num1, int num2) {
        if(num2 == 0){
            return num1;
        }
        return findGCD(num2, num1%num2);
    }
}
