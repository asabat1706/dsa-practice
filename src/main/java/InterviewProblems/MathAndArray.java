package InterviewProblems;

public class MathAndArray {
    public static void main(String[] args){
        int A[] = new int[101];
        for(int i=1; i<=100; i++){
            A[i] = 0;
        }
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(j%i==0){
                    if(A[j]==0) A[j]=1;
                    else A[j] = 0;
                }
            }
        }
        int count=0;
        for(int i=1; i<=100; i++){
            System.out.print(A[i] +" ");
            if(A[i]==1) count++;
        }
        System.out.println(count);

    }
}
