package boj.BarkingDog_Collection.MST;

/**
 * 행성 연결 골드4
 * MST - 프림
 * 892ms
 */
import java.io.*;
import java.util.*;
public class BOJ16398_prim {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<int []>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                graph[i].add(new int[]{j, c});
            }
        }

        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] ints : graph[1]) {
            pq.add(ints);
        }
        int  cnt = 0;
        long ans = 0;
        while (cnt < n - 1){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue;
            visited[temp[0]] = true;
            cnt++;
            ans += temp[1];
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(visited[next[0]]) continue;
                pq.add(next);
            }
        }
        System.out.println(ans);
    }
}
