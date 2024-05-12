package boj.BarkingDog_Collection.Graph;

// 이분 그래프 골드4
import java.util.*;
import java.io.*;
public class BOJ1707_Upgrade {
    static  ArrayList<Integer>[] graph;
    static  boolean [] visited;
    static  boolean flag = true;
    static int [] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 정점의 개수
            int m = Integer.parseInt(st.nextToken()); // 간선의 개수

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
            flag = true;
            visited = new boolean[n+1];
            memo = new int[n+1];
            Queue<int []> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                q.add(new int[]{i, 0});
                while (!q.isEmpty()){
                    int [] temp = q.poll();
                    int v = temp[0];
                    int depth = temp[1];
                    for (int j = 0; j < graph[v].size(); j++) {
                        int next = graph[v].get(j);
                        if(visited[next]){
                            if(memo[v] == memo[next]){
                                flag = false;
                                q.clear();
                                break;
                            }
                            continue;
                        }
                        visited[next] = true;
                        q.add(new int[]{next, depth + 1});
                        memo[next] = (depth + 1) % 2;
                    }
                }
            }

            if(flag) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
