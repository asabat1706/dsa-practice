package InterviewProblems;

public class LongestOnes1 {
    public static void main(String[] args){
        String A="111011101";
        if(A.endsWith("1")) A = A+"0";
        int count0 = 0, count1=0, ones_used=0, state=1, pre_max=0, ones_left=0;
        int total_ones=0;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='1') total_ones=total_ones+1;
        }
        ones_left=total_ones;
        for(int i=0; i<A.length(); i++) {
            if (A.charAt(i) == '1' && ones_left>0) {
                count1++;
                ones_left--;
                state=1;
                ones_used++;
            } else if (ones_used!=0) {
                count0++;
                if (count0 == 1 && state != 0){
                    if (ones_left >= 1) {
                        ones_left--;
                        count1++;
                    }}
                else {
                        pre_max = Math.max(count1, pre_max);
                        count1 = 0;
                        ones_left=total_ones;
                        count0=0;
                        if(state == 1){
                            int j = i-1;
                            while(j >=0){
                               if(A.charAt(j) != '0') j--;
                               else break;
                            }
                            i = j;
                        }
                    }
                state=0;
            }
        }
        pre_max = Math.max(count1,pre_max);
        System.out.println(pre_max);
    }
}
