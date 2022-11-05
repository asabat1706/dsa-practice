package SubArrays;

public class GoodSubArrays {
    public static void main(String[] args){
        int A[] = {1, 2, 3, 4, 5}; int B=4; int ga=0;
        for(int i=0; i<A.length; i++){
            int sum=0;
            for(int j=i; j<A.length;j++){
                sum=sum+A[j];
                int l = ((j-i)+1);
                if(l%2==0 && sum<B)
                    ga++;
                else if(l%2==1 && sum>B)
                    ga++;
            }
        }
        System.out.println(ga);
    }
}
