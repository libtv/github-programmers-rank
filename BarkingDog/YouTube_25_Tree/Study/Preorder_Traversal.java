package BarkingDog.YouTube_25_Tree.Study;

// 전위 순회
public class Preorder_Traversal {
    static int [] lc = {0,2,4,6,0,0,0,0,0};
    static int [] rc = {0,3,5,7,0,8,0,0,0};
    public static void main(String[] args) {
        preorder(1);
    }
    public static void preorder(int x){ // 전위 순회
        System.out.println(x);
        if(lc[x] != 0){
            preorder(lc[x]);
        }
        if(rc[x] != 0){
            preorder(rc[x]);
        }
    }
}
