package BitManipulation;

public class Test {
    public static void main(String[] args){
        int A[] = {1780, 170, 1157, 1922, 1032, 1922, 866, 681, 320, 2115, 1989, 1684, 1358, 2239, 681, 1501, 1989, 2239, 1780, 2416, 2115, 2416, 1501, 320, 483, 170, 1157, 1032, 1684, 483};
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                if(A[i]==A[j])
                    break;
            }
        }
        int a = 'C';
        System.out.println(a%65);
    }
}
