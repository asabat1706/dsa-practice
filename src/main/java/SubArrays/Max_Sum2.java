package SubArrays;

public class Max_Sum2 {
    public static void main(String[] args){
        int C[] = {7, 1, 8, 5, 8, 5, 3, 3, 5}; int B = 78;
        int sum_max=Integer.MIN_VALUE;
        for(int i=0; i<C.length; i++) {
            int sum=0;
            for(int j=i; j<C.length; j++){
                sum = sum+C[j];
                if(sum>sum_max){
                    if(sum <= B)
                      sum_max = sum;
                    else {
//                        sum = 0;
                        break;
                    }

                }
            }

        }
        System.out.println(sum_max);

    }
}
