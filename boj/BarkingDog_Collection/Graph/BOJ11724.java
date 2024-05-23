package boj.BarkingDog_Collection.Graph;

// 연결 요소의 개수 실버2
import java.util.*;
import java.io.*;
public class BOJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수 m
        ArrayList<Integer>[] graph = new ArrayList[n+1];
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
        boolean [] visited = new boolean[n+1];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            cnt++;
            visited[i] = true;
            q.add(i);
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
/*

방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.






 */