package org.example.BarkingDog.YouTube_25_Tree.Study;

// 후위 순회
public class Postorder_Traversal {
    static int [] lc = {0,2,4,6,0,0,0,0,0};
    static int [] rc = {0,3,5,7,0,8,0,0,0};
    public static void main(String[] args) {
      postorder(1);
    }
    public static void postorder(int x){
        if(lc[x]!=0) postorder(lc[x]);
        if(rc[x]!=0) postorder(rc[x]);
        System.out.println(x);
    }
}
