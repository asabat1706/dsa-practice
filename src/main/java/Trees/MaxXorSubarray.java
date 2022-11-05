package Trees;

import java.util.HashMap;

public class MaxXorSubarray {
    public static void main(String[] args){
//       int[] A={1,4,3};
       int[] A={8};
       int[] prefix_xor = new int[A.length+1];
       prefix_xor[0] = 0;
       int index=1;
       int max_xor=0; int start_ind=-1; int end_ind=-1;
       for(int i=0; i<A.length; i++){
           prefix_xor[index] = prefix_xor[i] ^ A[i];
           index++;
       }
       PrefixTrieBitNode dummy = new PrefixTrieBitNode(-1);
       insertIntoTrie(dummy,prefix_xor[0],0);
       for(int i=1; i<prefix_xor.length; i++){
           XorPair xor_pair = searchMaxXorPair(dummy,prefix_xor[i]);
           if(xor_pair.xor > max_xor){
               max_xor = xor_pair.xor;
               start_ind = xor_pair.index+1;
               end_ind = i;
           }else if(xor_pair.xor == max_xor){
               int curr_len = Math.abs(xor_pair.index - i);
               int max_len = end_ind - start_ind;
               if(max_len > curr_len){
                   start_ind = xor_pair.index+1;
                   end_ind = i;
               }
               else if(max_len == curr_len){
                 if(xor_pair.index < start_ind){
                     start_ind = xor_pair.index+1;
                     end_ind = i;
                 }
               }
           }
           insertIntoTrie(dummy,prefix_xor[i],i);
       }
        System.out.println(max_xor + "  " +start_ind + "  " + end_ind);
    }

    private static XorPair searchMaxXorPair(PrefixTrieBitNode dummy, int num) {
        PrefixTrieBitNode curr = dummy;
        StringBuilder xor_str = new StringBuilder();
        for(int i=31; i>=0; i--){
            int bit = (num>>i)&1;
            if((!curr.children.isEmpty()) && (curr.children.containsKey(1-bit))){
                xor_str.append(1);
                curr = curr.children.get(1-bit);
            }
            else
            {
                xor_str.append(0);
                curr = curr.children.get(bit);
            }
        }
        int xor_num = Integer.parseInt(xor_str.toString(),2);
        int ind = curr.endIndex;
        return new XorPair(xor_num,ind);
    }

    private static void insertIntoTrie(PrefixTrieBitNode dummy, int prefix_xor_num, int index) {
        PrefixTrieBitNode curr = dummy;
        for(int i=31; i>=0; i--){
            int bit = (prefix_xor_num>>i)&1;
            if(!curr.children.containsKey(bit)){
                curr.children.put(bit,new PrefixTrieBitNode(bit));
            }
            curr = curr.children.get(bit);
        }
        curr.endIndex = index;
    }
}
class PrefixTrieBitNode{
    int bit;
    HashMap<Integer,PrefixTrieBitNode> children;
    int endIndex;
    public PrefixTrieBitNode(int bit){
        this.bit=bit;
        children=new HashMap<>();
        endIndex=-1;
    }
}
class XorPair{
    int xor;
    int index;
    public XorPair(int xor, int index){
        this.xor = xor;
        this.index = index;
    }
}