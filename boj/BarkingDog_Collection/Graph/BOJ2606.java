package boj.BarkingDog_Collection.Graph;

import java.io.*;
import java.util.*;

// 바이러스 실버3
public class BOJ2606 {
    static int answer = 0;
    static  boolean [] visited;
    static ArrayList<Integer> [] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n+1];
        DFS(1);
        System.out.println(answer - 1);

    }
    public static void DFS(int v){
        visited[v] = true;
        answer++;
        for (int i = 0; i < graph[v].size(); i++) {
            int next = graph[v].get(i);
            if(visited[next]) continue;
            DFS(next);
        }
    }
}
