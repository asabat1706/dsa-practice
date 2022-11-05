public class String101 {
    public static void main(String[] args)
    {
        String s = "00100000100101111111";
        System.out.println(findOcurrance(s));
    }

    private static int findOcurrance(String s) {
        int count=0, count1s=0, count0s = 0;
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '0') {
                count0s++;
            }
            else {
                count1s++;
            }
            if(count0s==count1s) {
                count++;
                count0s=0;
                count1s=0;
            }
        }
        return count;
    }
}
