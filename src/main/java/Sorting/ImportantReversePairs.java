package Sorting;

public class ImportantReversePairs {
    static int count=0;
    static int mod =1000000007;
    public static void main(String[] args){
//        int[] A= {1, 3, 2, 3, 1};
//        int[] A={4, 1, 2};
//        int[] A={14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611};
//        int[] A={769, -71, 599, -1438, -530, -512, 1680, 1907, -301, 492, -844, 1765, -188, 685, -1879, -699, -990, 1022, 459, 528, -930, 1051, 1412, -1598, 245, -480, 1979, 1212, 1177, 447, -509, 881, 1968, -1603, -429, 1165, 405, 426, -1610, 931, -835, -1156, 1273, -143, -940, 199, -1886, -1646, 390, -1349, -256, -256, -103, -135, 637, -605, 55, -1805, -17, -229, 1162, 288, -818, -922, 32, -1032, -1823, -1874, -1650, 146, 721, 1586, 1969, 1720, -993, -1137, -1233, -1629, -879, -277, 444, -1191, -1273, 127, 1785, 1407, -1460, 414, -1578, -1348, 72, -794, 632, 877, 338, 1921, -650, -1314, 1187, -40};
        int[] A ={2000000000, 2000000000, -2000000000};
        mergeSort(A,0,A.length-1);
        System.out.println(count%mod);
    }

    private static void mergeSort(int[] a, int s, int e) {
        if(s>=e) return;
        int mid = (s+e)/2;
        mergeSort(a,s,mid);
        mergeSort(a,mid+1,e);
        merge(a,s,mid,e);
    }

    private static void merge(int[] a, int s, int mid, int e) {
        int left_size = (mid-s+1);
        int right_size = (e-mid);
        int left_array[] = new int[left_size];
        int right_array[] = new int[right_size];
        int index=0;
        for(int i=s; i<=mid; i++){
            left_array[index++]=a[i];
        }
        index=0;
        for(int i=(mid+1); i<=e; i++){
            right_array[index++]=a[i];
        }
        int i=0, j=0; index=s;
        while((i<left_size) && (j<right_size)) {
            long num1 = left_array[i];
            long num2 = (2L * right_array[j]);
            if (num1 > num2) {
                count = ((count % mod) + ((left_size - i)) % mod) % mod;
                j++;
            }
            else i++;
        }
        i=0;j=0;
        while((i<left_size) && (j<right_size)){
            if(left_array[i] <= right_array[j]){
                a[index] = left_array[i];
                i++; index++;
            }
            else{
                a[index] = right_array[j];
                j++; index++;
            }
        }
        while(i<left_size){
            a[index++] = left_array[i++];
        }
        while(j<right_size){
            a[index++] = right_array[j++];
        }
    }
}
