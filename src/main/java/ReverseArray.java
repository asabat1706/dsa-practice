public class ReverseArray {
    public static void main(String[] args){
        int a[] = {1,2,3,4};
        int i=0, j= a.length-1;
        while(i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        for(int e : a){
            System.out.print(e + " ");
        }
    }
}
