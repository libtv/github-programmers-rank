package boj.BarkingDog_Collection.Dijkstra;

/**
 * 최소비용 구하기 골드5
 */
import java.io.*;
import java.util.*;
public class BOJ1916 {
    static final int INF = 1000 * 100000; // 도시의 개수 * 버스 최대 비용
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        // 그래프 초기화
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 input
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int v1   = Integer.parseInt(st.nextToken());
            int v2   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v1].add(new int[]{v2, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작 도시
        int end   = Integer.parseInt(st.nextToken()); // 도착 도시

        int [] min = new int[n+1];
        Arrays.fill(min, INF);
        min[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()){
            int [] temp = pq.poll();
            if(min[temp[0]] != temp[1]) continue;
            for (int i = 0; i < graph[temp[0]].size(); i++) {
                int [] next = graph[temp[0]].get(i);
                if(min[next[0]] <= temp[1] + next[1]) continue;
                min[next[0]] = temp[1] + next[1];
                pq.add(new int[]{next[0], min[next[0]]});
            }
        }
        System.out.println(min[end]);
    }
}
