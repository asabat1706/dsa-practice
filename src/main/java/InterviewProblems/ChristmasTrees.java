package InterviewProblems;

public class ChristmasTrees {
    public static void main(String[] args){
        int A[] = {5, 9, 10, 4, 7, 8};
        int B[]=  {5, 6, 4, 7, 2, 5};
        int min_cost = Integer.MAX_VALUE;

        if (A.length > 3) {
            for (int i = 0; i <= A.length - 3; i++) {
                int cost = B[i];
                int count = 1;
                for (int j = i + 1; j <= A.length - 2; j++) {
                    if (A[j] > A[i]) {
                        cost = cost + B[j];
                        count++;
                        for (int k = j + 1; k < A.length; k++) {
                            if (A[k] > A[j]) {
                                cost = cost + B[k];
                                count++;
                                if (count == 3) {
                                    min_cost = Math.min(cost, min_cost);
                                    count--;
                                    cost = B[i] + B[j];
                                }
                            }
                        }
                        count--;
                        cost = B[i];
                    }
                }
                count--;
                cost = 0;
            }
        }
        else{
            if((A[0] > A[1]) && (A[1]>A[2]))
              min_cost = B[0]+B[1]+B[2];
        }
        if(min_cost == Integer.MAX_VALUE)
             min_cost=-1;
        System.out.println(min_cost);
    }
}
