package boj.BarkingDog_Collection.MST;

/**
 * 물대기 골드2
 * MST
 * 13%  -> 가장 우물 비용이 적은 우물에서 mst 시작
 * 100% -> 가상의 정점 활용 (우물 = 0)
 */
import java.util.*;
import java.io.*;
public class BOJ1368 {
    static int sum = 0;
    static int [] cost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 논의 수

        cost = new int[n+1];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int c = Integer.parseInt(br.readLine());
            list.add(new int[]{i, c});
            cost[i] = c;
        }

        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(i == j){
                    graph[0].add(new int[]{i, cost[i]});
                    continue;
                }
                graph[i].add(new int[]{j, c});
            }
        }

        boolean [] visited = new boolean[n+1];
        visited[0] = true;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] ints : graph[0]) {
            pq.add(ints);
        }

        int cnt = 0;
        while (cnt < n){
            int [] temp = pq.poll();
            if(visited[temp[0]]) continue;
            visited[temp[0]] = true;
            cnt++;
            sum += temp[1];
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(visited[next[0]]) continue;
                pq.add(next);
            }
        }
        System.out.println(sum);
    }
}
