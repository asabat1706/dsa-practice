public class EquiIndex {
    public static void main(String[] args){
        int A[] = {2,1,6,4};
        int PSE[] = new int[A.length];
        int PSO[] = new int[A.length];
        PSE[0] = A[0]; PSO[0]=0;
        for(int i=1; i<A.length;i++){
            if(i%2==0) {
                PSE[i] = PSE[i - 1] + A[i];
                PSO[i] = PSO[i - 1];
            }
            else{
                PSE[i] = PSE[i-1];
                PSO[i] = PSO[i-1]+A[i];
            }
        }
        for(int i=0; i<A.length; i++){
            int sume=0, sumo=0;
            if(i==0) {
                sume = (PSO[A.length - 1] - PSO[i + 1]);
                sumo = (PSE[A.length - 1] - PSE[i + 1]);
            }
            else if(i==A.length-1){
                sume = PSE[i];
                sumo = PSO[i];
            }
            else{
                sume = PSE[i - 1] + (PSO[A.length - 1] - PSO[i]);
                sumo = PSO[i - 1] + (PSE[A.length - 1] - PSE[i]);
            }
            if(sume == sumo)
                System.out.println(A[i]);
        }
    }
}
