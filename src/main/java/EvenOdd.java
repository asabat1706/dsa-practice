public class EvenOdd {
    public static void main(String[] args) {
        int a[] = {509800927, 348992125, 733735508, 654457679, 499101452, 855551825, 443382987};
        int e[] = new int[7], o[] = new int[7];
        int k = 0, t = 0;
        for (int j = 0; j < 7; j++) {
            if ((a[j] % 10)%2 == 0) {
                e[k] = a[j];
                k++;
            } else {
                o[t] = a[j];
                t++;
            }
        }
        for (int j = 0; j < t; j++) {
            System.out.print(o[j] + " ");
        }
        for (int j = 0; j < k; j++) {
            System.out.print(e[j] + " ");
        }
    }
}
