package AdvancedModular;

public class SumPairModulo {
    public static void main(String[] args){
        int[] A = {93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49};
        int B = 37;
        int[] freq_arr = new int[B];
        int mod = (int)Math.pow(10,9) + 7;
        for(int i=0; i<A.length; i++){
            int index = A[i]%B;
            freq_arr[index]++;
        }
        int i=0, j=B-1; int count=0;
        count += ((freq_arr[0]%mod) * ((freq_arr[0]-1)%mod)/2)%mod;
        while(i < j){
            if(j != B/2) {
                count += ((freq_arr[i]%mod) * (freq_arr[j]%mod))%mod;
            }
            i++;
            j--;
        }
        if(B%2 == 0){
            count += (((freq_arr[B/2]%mod) * ((freq_arr[B/2]-1)%mod))/2)%mod;
        }
        System.out.println(count);
    }
}
