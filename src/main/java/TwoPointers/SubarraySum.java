package TwoPointers;

public class SubarraySum {
    public static void main(String[] args){
        int[] A={ 42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37};
        int B=100;
        int start=-1, end=-1;
        int s=0, e=0;
        int sum=0; int last_add_ind=-1;
        while((s<A.length) && (e<A.length)){
            if(s != e){
                if(last_add_ind != e) {
                    sum += A[e];
                    last_add_ind = e;
                }
                if(sum < B){
                    e++;
                }
                if(sum > B){
                    sum -= A[s];
                    s++;
                }
                    if(sum == B) {
                        start = s;
                        end = e;
                        break;
                    }
            }
            else{
                sum = A[s];
                if(sum == B){
                    start = s;
                    end = e;
                    break;
                }
                else{
                    e++;
                }
            }

        }
        if(start!=-1){
          start++; end++;
        }
        System.out.println(start + "   "+ end);
    }
}
