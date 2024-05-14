package study.UnionFind;

import java.util.Arrays;

// 유니온 파인드 알고리즘 구현 하기
public class UnionFind {
    public static int [] parent = new int[11];

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        else return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            // y > x
            parent[y] = x;
            // x > y
            // parent[x] = y;
        }
    }

    public static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return true;
        return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            parent[i] = i;
        }

        System.out.println(Arrays.toString(parent));
        union(1, 2);
        System.out.println(Arrays.toString(parent));
        union(2, 3);
        System.out.println(Arrays.toString(parent));
        union(4, 5);
        union(4, 6);
        System.out.println(Arrays.toString(parent));
        System.out.println(isSameParent(1, 3)); // 그래프 연결?

    }


}
