package boj.BarkingDog_Collection.Tree;

// 민서의 응급 수술 골드4
import java.util.*;
import java.io.*;
public class BOJ20955 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 뉴련의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 시냅스의 개수 m
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
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            cnt++;
            int a = 1; // 정점의 개수
            int b = 0; // 간선의 개수
            q.add(i);
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if(visited[next]){
                        b++;
                    }
                    else{
                        b++;
                        a++;
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            sum += (b / 2) - (a - 1);
        }
        sum += cnt - 1;
        System.out.println(sum);
    }
}
