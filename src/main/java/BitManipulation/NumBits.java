package BitManipulation;

public class NumBits {
    public static void main(String[] args){
        int num = 11; int count=0;
        String binary="";
        while(num>=1){
            int d = num%2;
            binary = d+binary;
            num = num/2;
        }
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i)=='1')
                count++;
        }
        System.out.println(count);
    }
}
