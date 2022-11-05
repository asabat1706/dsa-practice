package Trees;

public class SingleChildBST {
    public static void main(String[] args){
        int[] preorder = {1, 5, 6, 4};
        int min=preorder[preorder.length-1];
        int max=preorder[preorder.length-1];

        boolean isBST = true;
        for(int i= preorder.length-2; i>=0; i--){
            if(preorder[i] >= min && preorder[i] < max){
                isBST=false;
                break;
            }
            min = Math.min(preorder[i],min);
            max = Math.max(preorder[i],max);
        }
        System.out.println(isBST);
    }
}
