package boj.BarkingDog_Collection.Tree;

// 트리 골드4
import java.util.*;
import java.io.*;
public class BOJ4803 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == m && m == 0) break;
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            while (m --> 0){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            int count = 0;
            boolean [] visited = new boolean[n+1];
            Stack<Integer> stack = new Stack<>();
            for (int i = 1; i <= n; i++) {
                 if(visited[i]) continue;
                 int a = 1; // 정점의 개수
                 int b = 0; // 간선의 개수
                 visited[i] = true;
                 stack.push(i);
                 while (!stack.isEmpty()){
                     int cur = stack.pop();
                     for (int j = 0; j < graph[cur].size(); j++) {
                         int next = graph[cur].get(j);
                         b++;
                         if(!visited[next]){
                             a++;
                             visited[next] = true;
                             stack.push(next);
                         }
                     }
                 }
                 if(b / 2 == a - 1) count++;
            }

            sb.append("Case ").append(++cnt).append(": ");
            if(count == 0){
                sb.append("No trees.");
            }
            else if(count == 1){
                sb.append("There is one tree.");
            }
            else{
                sb.append("A forest of ").append(count).append(" trees.");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
