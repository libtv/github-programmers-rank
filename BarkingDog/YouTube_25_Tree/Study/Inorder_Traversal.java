package org.example.BarkingDog.YouTube_25_Tree.Study;

// 중위 순회 구현하기
public class Inorder_Traversal {
    static int [] lc = {0,2,4,6,0,0,0,0,0};
    static int [] rc = {0,3,5,7,0,8,0,0,0};

    public static void main(String[] args) {
        Inorder(1);
    }
    public static void Inorder(int x){
        if(lc[x]!=0) Inorder(lc[x]);
        System.out.println(x);
        if(rc[x]!=0) Inorder(rc[x]);
    }
}
