package Advanced_Arrays;

public class RainTrap {
    public static void main(String[] args) {
        int A[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int count=0;
        int[] Rmax = new int[A.length];
        int[] Lmax = new int[A.length];
        Rmax[A.length-1] = A[A.length-1];
        for (int i = A.length - 2; i >= 0; i--) {
            Rmax[i] = Math.max(A[i], Rmax[i + 1]);
        }
        Lmax[0] = A[0];
        for(int i=1; i<A.length; i++){
            Lmax[i] = Math.max(A[i], Lmax[i-1]);
        }
        for(int i=1; i<A.length-1; i++){
            if(Lmax[i] > A[i] && Rmax[i] > A[i]) {
                int h = Math.abs(Lmax[i]-Rmax[i]);
                count += h;
            }
        }
        System.out.println(count);
    }
}
