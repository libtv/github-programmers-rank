package boj.BarkingDog_Collection.Dijkstra;

/**
 * 최단 경로 골드4
 * 다익스트라
 */
import java.io.*;
import java.util.*;
public class BOJ1753 {
    static final int INF = 10 * 20000; // 간선의 최대 가중치 * 정점의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점의 개수  1 <= v <= 20000
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수  1 <= e <= 300/000

        int s = Integer.parseInt(br.readLine());  // 시작 정점

        ArrayList<int[]>[] graph = new ArrayList[v+1]; // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방향 그래프
        while (e-->0){
            st = new StringTokenizer(br.readLine());
            int sv = Integer.parseInt(st.nextToken()); // 시작 정점
            int ev = Integer.parseInt(st.nextToken()); // 도착 정점
            int c = Integer.parseInt(st.nextToken());  // 가중치
            graph[sv].add(new int[]{ev, c});
        }

        int [] min = new int[v+1];
        Arrays.fill(min, INF);
        min[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()){
            int [] temp = pq.poll();
            if(min[temp[0]] != temp[1]) continue; // 확정된 정점인데 값이 다른 경우
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(min[next[0]] <= min[temp[0]] + next[1]) continue;
                min[next[0]] = min[temp[0]] + next[1];
                pq.add(new int[]{next[0], min[next[0]]});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(min[i] == INF){
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(min[i]).append("\n");
        }
        System.out.println(sb);
    }
}
