package Trees;

import java.util.HashMap;

public class MaxXorPair {
    public static void main(String[] args){
//        int[] A = {8,9,10,7};
        int[] A = {5, 17, 100, 11};
        int max_xor = 0;
        TriebitNode dummy = new TriebitNode(-1);
        for(int i=0; i<A.length; i++){
            insertBitsIntoTrie(dummy,A[i]);
        }
        for(int i=0; i<A.length; i++){
            String binarynum = serachXorBits(dummy,A[i]);
            int num = Integer.parseInt(binarynum,2);
            max_xor = Math.max(max_xor,num);
        }
        System.out.println(max_xor);
    }

    private static String serachXorBits(TriebitNode dummy, int num) {
        TriebitNode curr = dummy; StringBuilder xor_num= new StringBuilder();
        for(int i=5; i>=0; i--){
            int bit = ((num>>i) & 1);
            if(curr.children.containsKey(1-bit)){
                xor_num.append(1);
                curr = curr.children.get(1-bit);
            }
            else
            {
                xor_num.append(0);
                curr = curr.children.get(bit);
            }
        }
        return xor_num.toString();
    }

    private static void insertBitsIntoTrie(TriebitNode dummy, int num) {
        TriebitNode curr = dummy;
        for(int i=5; i>=0; i--){
            int bit = (num>>i &1);
            if(!curr.children.containsKey(bit)){
                curr.children.put(bit,new TriebitNode(bit));
            }
            curr = curr.children.get(bit);
        }
    }
}
class TriebitNode{
    int val;
    HashMap<Integer,TriebitNode> children;
    public TriebitNode(int val){
        this.val = val;
        children = new HashMap<>();
    }
}
