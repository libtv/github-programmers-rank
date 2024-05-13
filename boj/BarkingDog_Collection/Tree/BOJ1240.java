package boj.BarkingDog_Collection.Tree;

// 노드사이의 거리 골드5
import java.io.*;
import java.util.*;
public class BOJ1240 {
    public static ArrayList<Integer>[] graph;
    public static int [][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 개수 N
        int m = Integer.parseInt(st.nextToken()); // 거리를 알고 싶은 노드 쌍의 개수 m

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        distance = new int[n+1][n+1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            distance[u][v] = d;
            distance[v][u] = d;
            graph[u].add(v);
            graph[v].add(u);
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작 정점
            int e = Integer.parseInt(st.nextToken()); // 도착 정점
            boolean [] visited = new boolean[n+1];
            Queue<int []> q = new LinkedList<>();
            q.add(new int[]{s, 0});
            visited[s] = true;
            while (!q.isEmpty()){
                int [] temp = q.poll();
                int cur = temp[0];
                int dis = temp[1];
                for (int i = 0; i < graph[cur].size(); i++) {
                    int next = graph[cur].get(i);
                    if(visited[next]) continue;
                    visited[next] = true;
                    if(next == e){
                        sum = dis + distance[cur][e];
                        q.clear();
                        break;
                    }
                    else{
                        q.add(new int[]{next, dis + distance[cur][next]});
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
