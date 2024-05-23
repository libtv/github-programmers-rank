package boj.BarkingDog_Collection.Tree;

// 트리 순회 실버1
import java.io.*;
import java.util.*;
public class BOJ1991_Array {
    static StringBuilder sb = new StringBuilder();
    static int [][] tree = new int[26][3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            if(left != - 19) tree[parent][0] = left;
            if(right != - 19) tree[parent][1] = right;
            tree[parent][2] = parent + 'A';
        }
        PreOrder(0);
        sb.append("\n");
        InOrder(0);
        sb.append("\n");
        PostOrder(0);
        System.out.println(sb);
    }
    public static void PreOrder(int v){
        sb.append((char)tree[v][2]);
        if(tree[v][0] != 0) PreOrder(tree[v][0]);
        if(tree[v][1] != 0) PreOrder(tree[v][1]);
    }
    public static void InOrder(int v){
        if(tree[v][0] != 0) InOrder(tree[v][0]);
        sb.append((char)tree[v][2]);
        if(tree[v][1] != 0) InOrder(tree[v][1]);
    }
    public static void PostOrder(int v){
        if(tree[v][0] != 0) PostOrder(tree[v][0]);
        if(tree[v][1] != 0) PostOrder(tree[v][1]);
        sb.append((char)tree[v][2]);
    }
}
