package boj.BarkingDog_Collection.Tree;

// 트리 순회 골드4
import java.util.*;
import java.io.*;
public class BOJ22856 {
    static int count = 0;
    static  int [][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(left != -1) tree[parent][0] = left;
            if(right != -1) tree[parent][1] = right;
        }
        InOrder(1, true);

        System.out.println(count);
    }
    public static void InOrder(int v, boolean flag){
        if(tree[v][0] != 0) InOrder(tree[v][0], false);
        if(flag){
            if(tree[v][1] != 0) InOrder(tree[v][1], true);
        }
        else{
            if(tree[v][1] != 0) InOrder(tree[v][1], false);
        }
        if(v != 1){
            if(flag){
                count += 1;
            }
            else count += 2;
        }
    }
}
