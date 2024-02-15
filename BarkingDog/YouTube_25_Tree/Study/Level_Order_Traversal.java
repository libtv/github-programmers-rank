package org.example.BarkingDog.YouTube_25_Tree.Study;

import java.util.LinkedList;
import java.util.Queue;

// 이진 트리 - 레벨 순회
public class Level_Order_Traversal {
    public static void main(String[] args) {
        // 1차원 배열로 구현
        int [] lc = {0,2,4,6,0,0,0,0,0};
        int [] rc = {0,3,5,7,0,8,0,0,0};

        // 부모 , depth를 기록 해보자!
        int [] parent = new int[9];
        int [] depth = new int[9];

        // root = 1
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int cur = q.poll();
            if(lc[cur] != 0)
                q.add(lc[cur]);
                parent[lc[cur]] = cur;
                depth[lc[cur]] = depth[cur] + 1;
            if(rc[cur] != 0){
                q.add(rc[cur]);
                parent[rc[cur]] = cur;
                depth[rc[cur]] = depth[cur] + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 8; i++) {
            sb.append( i + ": 부모는 " + parent[i] + " depth는 " + depth[i]).append(" ");
        }
        System.out.println(sb);
    }
}
