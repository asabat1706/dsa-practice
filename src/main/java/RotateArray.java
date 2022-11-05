public class RotateArray {
    public static void main(String[] args){
        int a[] = {1,1,1,1,1};
        int size = 5;
        int no_of_rotation = 6;
        int final_a[] = new int[size];

        for(int i=0; i<size; i++){
           int t = i+no_of_rotation;
           if(t >= size)
               t = (t-size)%size;
           else t=t%size;
          final_a[t] = a[i];
        }
        for(int i: final_a)
            System.out.print(i + " ");

    }

}
