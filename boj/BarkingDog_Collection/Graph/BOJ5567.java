package boj.BarkingDog_Collection.Graph;

// 결혼식 실버2
import java.util.*;
import java.io.*;
public class BOJ5567 {
    static ArrayList<Integer> [] graph;
    static int [] visited;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[v].add(u);
            graph[u].add(v);
        }

        visited = new int[n+1];
        Arrays.fill(visited, 1000000);
        DFS(1, 0);
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if(visited[i] != 1000000){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void DFS(int v, int depth){
        visited[v] = depth;
        answer++;
        if(depth == 2) return;
        for (int i = 0; i < graph[v].size(); i++) {
            int next = graph[v].get(i);
            if(depth + 1 >= visited[next]) continue;
            DFS(next, depth + 1);
        }
    }
}
