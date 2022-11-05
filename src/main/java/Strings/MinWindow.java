package Strings;

import java.util.HashMap;

public class MinWindow {
    public static void main(String[] args){
//        String A="ADOBECODEBANC";
//        String B="ABC";
        String A="xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
        String B="dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";
//        String A = "0mJdGXwLm9AOZ5xA8u92KDYqGJroQ537hoRXjQoUCMOpDYwxoNjexJGWQJAIxSFF3ZbIe27oFxUTJxtv8mORwpuRZn30MDj3kXRW2Ix3lslj7kwmGZPXAKhBW4q5T2BzsqbL0ZETFqRdxVm8GCGfqshvpWzsRvprUcF9vw3VlftqTRzKRzr4zYB2P6C7lg3I7EhGMPukUj8XGGZTXqPqnCqes";
//        String B= "rsm2ty04PYPEOPYO5";
//        String A="AAAAA";
//        String B="AA";
//        String A = "ABDAAABC";
//        String B = "ABC";
        int expected_count = B.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch : B.toCharArray()){
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
            }
            else hm.put(ch, hm.get(ch)+1);
        }
        int start_index=0, end_index=0, min_len=Integer.MAX_VALUE;
        int min_start=-1, min_end=-1;
        while(end_index < A.length()) {
            char end_char = A.charAt(end_index);
            char start_char = A.charAt(start_index);
            if (hm.containsKey(end_char)) {
                int b_count = hm.get(end_char);
                if (b_count > 0) expected_count--;
                hm.put(end_char, b_count - 1);
            }
            while (expected_count == 0) {
                int len = end_index - start_index + 1;
                if (len < min_len) {
                    min_len = len;
                    min_start = start_index;
                    min_end = end_index;
                }
                if (hm.containsKey(start_char) && hm.get(start_char) < 0) {
                    hm.put(start_char,hm.get(start_char)+1);
                    start_index++;
                    start_char = A.charAt(start_index);
                }
                else if(!hm.containsKey(start_char)){
                    start_index++;
                    start_char = A.charAt(start_index);;
                }
                else break;
            }
            end_index++;
        }
//        System.out.println(A.indexOf('I',273));
//        System.out.println(min_start + "  ");
        System.out.println(A.substring(min_start,min_end+1));
    }
}
