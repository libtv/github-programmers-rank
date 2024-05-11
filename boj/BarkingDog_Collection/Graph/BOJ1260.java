package boj.BarkingDog_Collection.Graph;

// DFS와 BFS 실버2

import java.io.*;
import java.util.*;
public class BOJ1260 {
    static boolean [] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수 m
        int v = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점 번호 v

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        sb = new StringBuilder();
        visited = new boolean[n+1];

        DFS(v);
        sb.append("\n");
        Arrays.fill(visited, false);

        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        sb.append(v).append(" ");
        visited[v] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            Collections.sort(graph[cur]);
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    sb.append(next).append(" ");
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
    public static void DFS(int v){
        sb.append(v).append(" ");
        visited[v] = true;
        Collections.sort(graph[v]);
        for (int i = 0; i < graph[v].size(); i++) {
            int next = graph[v].get(i);
            if(!visited[next]){
                DFS(next);
            }
        }
    }
}
