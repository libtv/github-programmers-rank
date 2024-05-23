package boj.BarkingDog_Collection.Tree;

// 회사 문화1 골드4
import java.io.*;
import java.util.*;
public class BOJ14267 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 칭찬 횟수

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(i == 1) continue;
            graph[i].add(parent);
            graph[parent].add(i);
        }

        int [] level = new int[n+1];
        level[1] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(level[next] != 0) continue;
                level[next] = level[cur] + 1;
                q.add(next);
            }
        }

        int [] memo = new int[n+1];
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            memo[i] += w;
        }

        q.add(1);
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(level[next] > level[cur]){
                    q.add(next);
                    memo[next] += memo[cur];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(memo[i]).append(" ");
        }
        System.out.println(sb);
    }
}