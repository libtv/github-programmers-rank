package boj.BarkingDog_Collection.Dijkstra;

/**
 * 파티 골드3
 * 다익스트라
 */
import java.io.*;
import java.util.*;
public class BOJ1238 {
    static final int INF = 1000 * 100; // 마을의 최대 개수 1000 * 간선 최대 시간 100
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 마을의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int x = Integer.parseInt(st.nextToken()); // 파티 참석 마을

        // 그래프 초기화
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 input 단방향
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int sv = Integer.parseInt(st.nextToken());
            int ev = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[sv].add(new int[]{ev,c});
        }

        // x에서 다시 각자 마을로 돌아가는 case
        int [] min = new int[n+1];
        Arrays.fill(min, INF);
        min[x] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{x, 0});
        while (!pq.isEmpty()){
            int [] temp = pq.poll();
            if(min[temp[0]] != temp[1]) continue;
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(min[next[0]] <= min[temp[0]] + next[1]) continue;
                min[next[0]] = min[temp[0]] + next[1];
                pq.add(new int[]{next[0], min[next[0]]});
            }
        }
        int [] memo = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(x == i) continue;
            int [] check = new int[n+1];
            Arrays.fill(check, INF);
            check[i] = 0;
            pq.add(new int[]{i, 0});
            while (!pq.isEmpty()){
                int [] temp = pq.poll();
                if(check[temp[0]] != temp[1]) continue;
                for (int j = 0; j < graph[temp[0]].size(); j++) {
                    int [] next = graph[temp[0]].get(j);
                    if(check[next[0]] <= check[temp[0]] + next[1]) continue;
                    check[next[0]] = check[temp[0]] + next[1];
                    pq.add(new int[]{next[0], check[next[0]]});
                }
            }
            memo[i] = check[x];
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, memo[i] + min[i]);
        }
        System.out.println(max);

    }
}
