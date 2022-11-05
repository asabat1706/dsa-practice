package SubArrays;

public class LessSubArrays {
        public static void main(String[] args){
            int C[] = {2, 5, 6}; int B = 10;
            int count=0;
            for(int i=0; i<C.length; i++) {
                int sum=0;
                for(int j=i; j<C.length; j++){
                    sum = sum+C[j];
                    if(sum <= B)
                        count++;
                    else {
                        break;
                    }
                }

            }
            System.out.println(count);
        }
    }

