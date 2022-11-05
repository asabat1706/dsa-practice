package Searching;

public class PaintersPartition {
    static long min_time=Integer.MAX_VALUE;
    static int mod=10000003;
    public static void main(String[] args){
        int[] C = {1000000,1000000};
        int A = 1, B=1000000;
        long sum_time = C[0]; long max_time = Integer.MIN_VALUE;
        long[] times = new long[C.length];
        for(int i=0; i<C.length; i++){
            times[i] = C[i] * (long)B;
            sum_time = sum_time +times[i];
            max_time = Math.max(max_time,times[i]);
        }
        long s=max_time, e=sum_time;
        if(A==1) min_time=e;
        else if(A>C.length) min_time=s;
            while (s <= e) {
                long mid = s + (e - s) / 2;
                if (check(times, mid, A)) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
             }
        System.out.println(min_time%mod);
    }

    private static boolean check(long[] times, long mid, int noOfPeople) {
        long timeByEach=0; long maxTime = Integer.MIN_VALUE; int peopleLeft=noOfPeople;
        int i;
        for(i=0; i<times.length;){
            long time= timeByEach+times[i];
            if(time <= mid && peopleLeft>=1) {
                timeByEach += times[i];
                i++;
            }
            else{
                maxTime = Math.max(maxTime,timeByEach);
                peopleLeft--;
                timeByEach=0;
                if(peopleLeft==0)break;
            }
        }
        maxTime = Math.max(maxTime,timeByEach);
        if(i==times.length) {
            min_time= Math.min(min_time,maxTime);
            return true;
        }
        return false;
    }
}
