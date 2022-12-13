package Trees;

public class SubArrayXOR {
    public static void main(String[] args){
        int[] input = {8, 3, 10, 2, 6, 7, 6, 9, 3};
        int[] prefix_xor = new int[input.length];
        prefix_xor[0] = input[0];
        for(int i=1; i< input.length; i++){
            prefix_xor[i] = input[i] ^ prefix_xor[i-1];
        }
        TrieBit root = new TrieBit(-1);
        for(int i=0; i< input.length; i++){
            insertIntoTrie(root,prefix_xor[i]);
        }
//        for(int i)
    }

    private static void insertIntoTrie(TrieBit root, int num) {
        TrieBit current = root;
        for(int i=0; i<5; i++){
            int bit = ((num>>i) & 1);
            if(bit == 0 ){
                if(current.left == null) {
                    current.left = new TrieBit(0);
                }
                current = current.left;
            }
            else {
                if(current.right == null) {
                    current.right = new TrieBit(1);
                }
                current = current.right;
            }
        }
    }
}

class TrieBit{
    int val;
    TrieBit left;
    TrieBit right;
    public TrieBit(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
